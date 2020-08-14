package threads;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2)  {

        try {
            BigInteger result;

            PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
            PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println(thread1.result);
            System.out.println(thread2.result);
            result = thread1.result.add(thread2.result);
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return base1;


    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = base.pow(power.intValue());

        }

        public BigInteger getResult() {
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new ComplexCalculation().calculateResult(new BigInteger("238"),new BigInteger("128"),new BigInteger("2219"),new BigInteger("22312")));
    }
}