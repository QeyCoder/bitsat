package pubsub;

/**
 * Created by Gaurav on 16/04/18.
 */


public class Consumer implements Runnable {


    private final Manager manager;

    public Consumer(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {

        try {
            manager.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
