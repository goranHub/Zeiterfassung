package gui;


import data.dataStructure.Queues;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.PersonObserverForDB;
import logic.*;
import java.sql.Timestamp;


import static gui.MyScreen.*;
//project structure -> module ->add jars
// --module-path \Users\ll4\Downloads\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib --add-modules javafx.graphics,javafx.controls,javafx.base
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        TextField firstNameInput = new TextField();
        TextField secondNameInput = new TextField();

        TextField[] txtArr = new TextField[2];
        txtArr[0]= firstNameInput;
        txtArr[1]= secondNameInput;

        //buttons
        Button btnEntry = new Button("Entry");
        Button btnExit = new Button("Exit");
        Button btnReadFromDB = new Button("readFromDB");
        Button btnRemoveFromDB = new Button("remove all from DB");
        Button btnStackArrayPush = new Button("Push into stack array");
        Button btnStackArrayPop = new Button("Pop from stack array");

        Button[] btnArr={btnEntry,btnExit,btnReadFromDB,btnRemoveFromDB, btnStackArrayPush, btnStackArrayPop};


        PersonObserverForDB personObserverForDB = new PersonObserverForDB();
        Person person = new Person("","", new Timestamp(System.currentTimeMillis()));

        //add observer on person object
        person.addObserver(personObserverForDB);


        Queues queue = new Queues(10);
        primaryStage.setTitle("Zeiterfassung");
        primaryStage.setScene(makeScene( btnArr, person, personObserverForDB, txtArr, queue));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
