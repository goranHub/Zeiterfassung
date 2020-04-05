package logic;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PersonObserverForDB implements Observer {




    @Override
    public void update(Observable o, Object arg) {
        int i =0;
        i++;
        System.out.println("der " +i+ (ArrayList<String>)arg);
    }
}
