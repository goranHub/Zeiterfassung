package logic;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Person extends Observable {

    String fristName="";
    String lastName="";
    Timestamp timestamp;
    int id;



    public Person( String fristName, String lastName, Timestamp timestamp) {
        this.fristName = fristName;
        this.lastName = lastName;
        this.timestamp = timestamp;


    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getFristName() {
        return fristName;
    }

    public String getLastName() {
        return lastName;

    }

    public int getId() {
        return id;
    }

    public void setName(String fristName, String lastName) {


        Person person = new Person(fristName,lastName, new Timestamp(System.currentTimeMillis()));
        setChanged();
        notifyObservers(person);
    }





}
