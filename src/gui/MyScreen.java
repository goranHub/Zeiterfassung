package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import logic.*;



public class MyScreen {







    public static Scene makeScene(Button[] btnArr, Person person, PersonObserverForDB personObserver, TextField[] txtArr){

        VBox vBox = new VBox();

        vBox.getChildren().addAll(txtArr);

        vBox.getChildren().add(btnArr[0]);
        vBox.getChildren().add(btnArr[1]);
        vBox.getChildren().add(btnArr[2]);



        btnArr[0].setOnAction(e -> {
            String first =  txtArr[0].getText();
            String last  =  txtArr[1].getText();

            person.addObserver(personObserver);
            person.setName(first,last);
        });


        Scene scene = new Scene(vBox);
        return scene;
    }
}


