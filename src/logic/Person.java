package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Person extends Observable {

    String fristName;
    String lastName;


    public Person(String fristName, String lastName) {
        this.fristName = fristName;
        this.lastName = lastName;

    }

    public String getFristName() {
        return fristName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setName(String fristName, String lastName) {

        setChanged();
        List<String> info = new ArrayList<>();
        info.add(fristName);
        info.add(lastName);
        notifyObservers(info);
    }


}
