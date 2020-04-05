package logic;


import java.util.Observable;
import java.util.Observer;

public class PersonObserverForDB implements Observer {

    Person person;


    public Person getPerson() {
        return person;
    }




    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Person)arg).getFristName()+"   " + ((Person)arg).getLastName()+"   "  + ((Person)arg).getTimestamp());
        this.person = ((Person)arg);
    }



}
