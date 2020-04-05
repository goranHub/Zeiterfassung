package gui;

import data.DeleteFromDB;
import data.ReadAllFromDB;
import data.WriteIntoDB;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.*;

import java.sql.SQLException;
import java.sql.Timestamp;


public class MyScreen {

    static String first;
    static String last;
    static int i =0;

    public static Scene makeScene(Button[] btnArr,Person person, PersonObserverForDB personObserverForDB, TextField[] txtArr){

         VBox root = new VBox();


        root.getChildren().addAll(txtArr);

        root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));
        //add
        root.getChildren().add(btnArr[0]);
        //save to db
        root.getChildren().add(btnArr[1]);
        //readFromDB
        root.getChildren().add(btnArr[2]);
        //remove all from DB
        root.getChildren().add(btnArr[3]);
        //save to file
        root.getChildren().add(btnArr[4]);


        //add person and with setPerson notify all Observers
        btnArr[0].setOnAction(e -> {
            first =  txtArr[0].getText();
            last  =  txtArr[1].getText();
            person.setPerson(first,last,  new Timestamp(System.currentTimeMillis()));

            txtArr[0].clear();
            txtArr[1].clear();
        });


        //write one person in DB from personObserver
        btnArr[1].setOnAction(e->{

            try {
                //id++
                personObserverForDB.getPerson().setId(personObserverForDB.getPerson().getId() +(i++));
                WriteIntoDB.writeIntoDB(personObserverForDB.getPerson());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(personObserverForDB);

        });


        btnArr[2].setOnAction(e ->{
            try {
                ReadAllFromDB.main();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        btnArr[3].setOnAction(e->{
            try {
                DeleteFromDB.main();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        Scene scene = new Scene(root,400,350);
        return scene;
    }
}


