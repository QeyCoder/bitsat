package roundzero;

/**
 * Created by Gaurav on 16/04/18.
 */


public class Driver {


    public static void main(String[] args) throws InterruptedException {


        Manager manager = new Manager();

        Consumer consumer = new Consumer(manager);
        Producer producer = new Producer(manager);
        for (int i = 0; i < 5; i++) {


            Thread consumerThread = new Thread(consumer);
            Thread producerThread = new Thread(producer);

            producerThread.start();
            consumerThread.start();

            producerThread.join();
            consumerThread.join();
        }


    }


}
