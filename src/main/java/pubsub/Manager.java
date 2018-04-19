package pubsub;

import java.util.LinkedList;

/**
 * Created by Gaurav on 16/04/18.
 */


public class Manager {


    int size = 15;


    LinkedList<Integer> integers = new LinkedList<>();

    public synchronized void consume() throws InterruptedException {

        while (true) {
            while (integers.size() == 0)
                wait();
            Integer val = integers.removeFirst();
            notifyAll();
            System.out.println("consumed :" + val);
        }


    }

    public synchronized void produce() throws InterruptedException {
        int val = 0;
        while (true) {
            while (integers.size() == size)
                wait();
            integers.add(++val);
            notifyAll();
            System.out.println("produces :" + val);

        }

    }
}
