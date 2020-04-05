package gui;

import data.DeleteFromDB;
import data.ReadAllFromDB;
import data.WriteIntoDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import logic.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


public class MyScreen {

    static String first;
    static String last;
    static int i = 0;

    public static Scene makeScene(Button[] btnArr, Person person, PersonObserverForDB personObserverForDB, TextField[] txtArr) {

        VBox root = new VBox();


        root.getChildren().addAll(txtArr);

        root.setSpacing(10);
        root.setPadding(new Insets(15, 20, 10, 10));
        //Entry
        root.getChildren().add(btnArr[0]);
        //Exit
        root.getChildren().add(btnArr[1]);
        //readFromDB
        root.getChildren().add(btnArr[2]);
        //remove all from DB
        root.getChildren().add(btnArr[3]);


        btnArr[0].setOnAction(e -> {
            first = txtArr[0].getText();
            last = txtArr[1].getText();

            try {

                System.out.println(ReadAllFromDB.main()
                        .stream()
                        .filter(s->s.getFristName().equals(first))
                        .filter(s->s.getLastName().equals(last))
                        .collect(Collectors.toList()));



            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //setPerson send the upadate change to observer
            person.setPerson(first, last, new Timestamp(System.currentTimeMillis()));

            txtArr[0].clear();
            txtArr[1].clear();


            //write in db
            try {
                //id++
                personObserverForDB.getPerson().setId(personObserverForDB.getPerson().getId() + (i++));
                WriteIntoDB.writeIntoDB(personObserverForDB.getPerson());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });


        //exit when we have that person in the list
        btnArr[1].setOnAction(e -> {
            List<Person> peopleList;
            try {
                peopleList = ReadAllFromDB.main();

                for(Person person1 :peopleList){
                    first = txtArr[0].getText();
                    last = txtArr[1].getText();


                }
            }
             catch (SQLException ex) {
                    ex.printStackTrace();
                }

        });


        //read
        btnArr[2].setOnAction(e -> {
            try {
                List<Person> peopleList;
                peopleList = ReadAllFromDB.main();
                for (Person persona : peopleList) {
                    System.out.println(persona.getId() + "  " + persona.getFristName() + "  " + persona.getLastName() + "  " + persona.getTimestamp());
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        //remove all
        btnArr[3].setOnAction(e -> {
            try {
                DeleteFromDB.main();
                if(ReadAllFromDB.main().size() == 0){
                    System.out.println("is empty");
                }else
                {
                    System.out.println("its not empty");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        Scene scene = new Scene(root, 400, 350);
        return scene;
    }
}


