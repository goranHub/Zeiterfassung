package gui;

import data.WriteIntoDB;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import logic.*;

import java.sql.SQLException;
import java.sql.Timestamp;


public class MyScreen {

    static String first;
    static String last;
    static int i =0;

    public static Scene makeScene(Button[] btnArr,Person person, PersonObserverForDB personObserverForDB, TextField[] txtArr){

        VBox vBox = new VBox();

        vBox.getChildren().addAll(txtArr);

        vBox.getChildren().add(btnArr[0]);
        vBox.getChildren().add(btnArr[1]);
        vBox.getChildren().add(btnArr[2]);



        btnArr[0].setOnAction(e -> {
            first =  txtArr[0].getText();
            last  =  txtArr[1].getText();
            person.setName(first,last);
        });

        btnArr[1].setOnAction(e->{

            try {
                personObserverForDB.getPerson().setId(personObserverForDB.getPerson().getId() +(i++));
                WriteIntoDB.writeIntoDB(personObserverForDB.getPerson());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(personObserverForDB);



        });


        Scene scene = new Scene(vBox);
        return scene;
    }
}


