package data.dataStructure;
import logic.Person;
public class Queues {

    private static final int DEFAULT_CAPACITY = 10;

    private int maxSize;
    private Person[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queues(){
        this(DEFAULT_CAPACITY);
    }

    public Queues(int size){
        maxSize = size;
        queueArray = new  Person[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean insert(Person person){
        if(isFull()){
            return false;
        }
            rear = (rear +1)% maxSize;
            queueArray[rear] = person;
            nItems++;
            return true;
    }

    public Person remove(){
        if(isEmpty()){
            return null;
        }
        Person temp = queueArray[front];
        front = (front +1)% maxSize;
        nItems--;
        return temp;
    }

    public Person peekFront(){
        return queueArray[front];
    }

    public Person peekRear(){
        return queueArray[rear];
    }
    public boolean isEmpty(){
        return nItems ==0;
    }
    public boolean isFull(){
        return nItems == maxSize;
    }

    public int getSize(){
        return nItems;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front; ; i = ++i % maxSize) {
            sb.append(queueArray[i]).append(", ");
            if (i == rear) {
                break;
            }
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }


}

