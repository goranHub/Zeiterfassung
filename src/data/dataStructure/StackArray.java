package data.dataStructure;
import logic.Person;
import java.util.Arrays;

public class StackArray {

    private static final int DEFAULT_CAPACITY = 10;
    private int maxSize;
    private Person[] stackArray;
    private int top;

    public StackArray(){
        this(DEFAULT_CAPACITY);
    }

    public Person[] getStackArray() {
        return stackArray;
    }

    public StackArray(int size){
        maxSize = size;
        stackArray = new Person[maxSize];
        top = -1;
    }

    public void push(Person value){
        if(!isFull()){
            top++;
            stackArray[top] = value;
        }else {
            resize(maxSize *2);
            push(value);
        }
    }

    public Person pop(){
        if(!isEmpty()){
            return stackArray[top--];
        }else{
            System.out.println("the stack is already empty");
            return null;
        }
    }


    private boolean isFull() {
        return (top + 1 == maxSize);
    }

    public void makeEmpty() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top ==  -1);
    }

    public Person peek(){
        if(!isEmpty()){
            return stackArray[top];
        }else {
            System.out.println(" the stack is empty cant peek");
            return null;
        }
    }

    public void resize (int newSize){
        Person[] transferArray = new Person[newSize];
        for (int i =0; i<stackArray.length; i++){
            transferArray[i] = stackArray[i];
        }
        stackArray=transferArray;
        maxSize=newSize;
    }
    @Override
    public String toString() {
        return "StackArray{" +
                "maxSize=" + maxSize +
                ", stackArray=" + Arrays.toString(stackArray) +
                ", top=" + top +
                '}';
    }
}
