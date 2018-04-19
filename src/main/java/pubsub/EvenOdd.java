package pubsub;

/**
 * Created by Gaurav on 16/04/18.
 */


public class EvenOdd {


    public static void main(String[] args) throws InterruptedException {


        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();

        Thread eThread = new Thread(myThread);
        Thread oThread = new Thread(myThread1);

        oThread.start();
        eThread.start();

        oThread.join();
        eThread.join();


    }


    static class MyThread implements Runnable {
        static volatile boolean isEven = false;

        static volatile boolean count = true;

        @Override
        public void run() {

            try {

                synchronized (MyThread.class) {
                    if (count) {
                        count = !count;
                        printOdd();
                    } else {
                        count = !count;
                        printEven();
                    }

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void printOdd() throws InterruptedException {
            for (int i = 1; i <= 11; i += 2) {

                synchronized (MyThread.class) {


                    while (isEven) {
                        MyThread.class.wait();
                    }

                    System.out.println(i + " " + Thread.currentThread());
                    isEven = true;
                    MyThread.class.notify();
                }
            }
        }

        private static void printEven() throws InterruptedException {
            for (int i = 0; i <= 10; i += 2) {
                synchronized (MyThread.class) {
                    while (!isEven) {
                        MyThread.class.wait();
                    }
                    System.out.println(i + " " + Thread.currentThread());
                    isEven = false;
                    MyThread.class.notify();
                }
            }
        }
    }


}
