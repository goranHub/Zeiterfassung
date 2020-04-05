package gui;

import data.WriteIntoDB;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.PersonObserverForDB;
import logic.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static gui.MyScreen.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        TextField firstNameInput = new TextField();
        TextField secondNameInput = new TextField();
        TextField[] txtArr = new TextField[2];
        txtArr[0]= firstNameInput;
        txtArr[1]= secondNameInput;

        Button btnAdd = new Button("add");
        Button btnSaveToDB = new Button("save to db");
        Button btnSaveToFile = new Button("save to file");

        Button[] btnArr={btnAdd,btnSaveToDB,btnSaveToFile};



        PersonObserverForDB personObserverForDB = new PersonObserverForDB();
        Person person = new Person("","", new Timestamp(System.currentTimeMillis()));

        person.addObserver(personObserverForDB);
        //person.setName(first,last);





        //WriteIntoDB.writeIntoDB( personObserverForDB.getPerson() );


        primaryStage.setScene(makeScene( btnArr, person, personObserverForDB, txtArr));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
