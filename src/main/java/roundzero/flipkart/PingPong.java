package roundzero.flipkart;

/**
 * Created by Gaurav on 22/03/18.
 */


public class PingPong {

    static int MAX_TURN = 10;

    public static void main(String[] args) throws InterruptedException {

        Player player1 = new Player("Ping");
        Player player2 = new Player("Pong");
        player1.nextPlayer = player2;
        player2.nextPlayer = player1;
        player1.shouldPlay = true;
        Thread thread1 = new Thread(player1);

        Thread thread2 = new Thread(player2);
        System.out.println("Game started!");
        thread2.start();
        thread1.start();
        roundzero.Thread.sleep(20);

        //Tell the players to stop
        thread1.interrupt();
        thread2.interrupt();

        thread1.join();
        thread2.join();

        System.out.println("Game finished!");


    }

    /**
     * Multithreaded Approach
     */
    private static class Player implements Runnable {
        private final String text;
        private Player nextPlayer;

        private volatile boolean shouldPlay = false;

        public Player(String text) {
            this.text = text;
        }


        @Override
        public void run() {

            while (!roundzero.Thread.interrupted()) {
                while (!shouldPlay);

                System.out.println(text);
                System.out.println("--");
                this.shouldPlay = false;
                nextPlayer.shouldPlay = true;
            }

        }
    }


    /**
     * Single Threaded

     static class Player {
     private int turn = MAX_TURN;
     private final String text;
     private Player nextPlayer;

     public Player(String text) {
     this.text = text;
     }

     private boolean isGameFinished() {
     return turn == 0;
     }

     public void play() {
     if (!isGameFinished()) {
     System.out.println(this.text);
     turn--;
     System.out.println("---");
     nextPlayer.play();
     }
     }
     }
     */


}
