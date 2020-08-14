package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class JoinExample {


    public static void main(String[] args) throws InterruptedException {
        List<Long> nos = Arrays.asList(new Long[]{0l, 3l,32l, 343l, 563l, 15332934l});

        List<FactorialThread> factorialThreads =  new ArrayList<>();


        for (Long  ip : nos) {
            factorialThreads.add(new FactorialThread(ip));
        }

        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.setDaemon(true);
            factorialThread.start();
        }
        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.join(10000);
        }
        for (FactorialThread factorialThread : factorialThreads) {
            if(factorialThread.isIfFinished()){
                System.out.println("factorial of no "+ factorialThread.getInput() +" is "+ factorialThread.getResult());
            }else{
                System.out.println("factorial of no "+ factorialThread.getInput() +" is in process" );
            }
        }
    }


    static class FactorialThread extends Thread {


        private BigInteger result = BigInteger.ZERO;
        private long input;
        private boolean ifFinished;

        public FactorialThread(long input) {
            this.input = input;
        }

        @Override
        public void run() {
            result = calculateFactorial(input);
            ifFinished = true;
        }

        private BigInteger calculateFactorial(long input) {
            BigInteger temp = BigInteger.ONE;

            for (long i = input; i > 0; i--) {
                temp = temp.multiply(new BigInteger(Long.toString(i)));
            }
            return temp;
        }

        public long getInput() {
            return input;
        }

        public BigInteger getResult() {
            return result;
        }


        public boolean isIfFinished() {
            return ifFinished;
        }
    }
}



