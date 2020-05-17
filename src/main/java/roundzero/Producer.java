package roundzero;

/**
 * Created by Gaurav on 16/04/18.
 */


public class Producer implements Runnable {

    private final Manager manager;

    public Producer(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            manager.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
