package roundzero.flipkart;
import java.util.*;

/**
 * Created by Gaurav on 29/03/18.
 */


public class Test111  extends Object{


    static volatile A a;

    public synchronized static void main(String[] args) {

        Map<Object,String> s=  new TreeMap<>();
        a =  new A();
            a.print();
    }

    static class A {
        private  volatile Integer a;

       public void print() {
                synchronized (a) {//s
            }
            System.out.println("AE");
        }
    }

    static class B extends A {
         public void print() {
            System.out.println("BE");

        }
    }
}
