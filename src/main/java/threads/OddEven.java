package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OddEven {

//TODO this is incomplete
    public static void main(String[] args) throws InterruptedException {
String str =  new String();

        OddThread o = new OddThread(100,str);
        EvenThread e = new EvenThread(100,str);
        o.start();
        e.start();
        o.join();
        e.join();
    }

   static  class OddThread extends Thread{
       private final String str;
       int no;

       public OddThread(int no, String str) {
           this.str =  str;
           this.no = no;
       }

       @Override
       public void run() {
           for (int i = 0; i < no; i++) {
               if(i%2!=0){
                   System.out.println(i);

               }

           }
       }
   }
    static  class EvenThread extends Thread{
        private final String str;
        int no;

        public EvenThread(int no, String str) {
            this.str =  str;
            this.no = no;
        }

        @Override
        public void run() {
            for (int i = 0; i < no; i++) {
                try {
                    str.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i%2==0){
                    System.out.println(i);
                    str.notify();
                }

            }
        }
    }
}



