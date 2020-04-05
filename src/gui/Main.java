package gui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.PersonObserverForDB;
import logic.*;

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
        Button btnSaveToFile = new Button("save to file");
        Button btnSaveToDB = new Button("save to db");
        Button[] btnArr={btnAdd,btnSaveToDB,btnSaveToFile};



        PersonObserverForDB personObserver = new PersonObserverForDB();
        Person person = new Person("", "");



        primaryStage.setScene(makeScene( btnArr, person, personObserver, txtArr));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
