package data.dataStructure;
import logic.Person;
import java.util.ArrayList;


public class StackArrayList {

    private ArrayList<Person> stackList;

    public StackArrayList() {
        stackList = new ArrayList<>();
    }

    public ArrayList<Person> getStackList() {
        return stackList;
    }

    public void push(Person value) {
        stackList.add(value);
    }

    public Person pop() {
        if (!isEmpty()) {
            Person popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return popValue;
        } else {
            System.out.println("stack is already empty");
        }
        return new Person(null,null,null);
    }

    public Person peek() {
        return stackList.get(stackList.size() - 1);
    }

    public Boolean isEmpty() {
        return stackList.size() == 0;
        //return stackList.isEmpty();
    }


    @Override
    public String toString() {
        return pop().getFristName();
    }
}
