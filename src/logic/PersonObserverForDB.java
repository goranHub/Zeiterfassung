package logic;


import java.util.Observable;
import java.util.Observer;

public class PersonObserverForDB implements Observer {

    Person person;

    public PersonObserverForDB() {

    }

    public Person getPerson() {
        return person;
    }

    @Override
    public void update(Observable o, Object arg) {
        int i =0;
        i++;
        System.out.println("der " +i+ ((Person)arg).getFristName()+"   " + ((Person)arg).getLastName()+"   "  + ((Person)arg).getTimestamp());
        this.person = ((Person)arg);
    }



}
