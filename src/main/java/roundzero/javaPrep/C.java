package roundzero.javaPrep;

/**
 * Created by Gaurav on 11/04/18.
 */


public class C {

    static {

    }
    static C c = new C();
    private final int[] y;

    public C(int... x) {
        this.y = x;
    }

    public static synchronized void test() {
        S s =  new S();

    }

    public static void main(String[] args) {
        System.out.println(c.y);

        class P{
            int x;
        }
    }

    static class S{
        static  int x;
    }
}
