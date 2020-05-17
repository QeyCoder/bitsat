package roundzero.javaPrep;


public class Redwood {




    public Redwood(String s) {
    }

    static void m(Object x) {
         x = (int) x;
        System.out.println("long");
    }

    public static void main(String[] args) {

        byte x = 2;
        m((int)x);
        m( 2000000020000000222L);
        modify(x);
        System.out.println(x);

        Integer y = 0;
        modify(y);
        System.out.println(y);


        String t = "worlds";
        modify(t);
        System.out.println(t);


        Test tt = new Test("-");

        modify(tt);
        System.out.println(tt);

        int[] ints = new int[2];
        modify(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }

    private static void modify(int[] ints) {
        ints[0] = 9;
    }


    static void modify(int x) {
        x++;
    }

    static void modify(Integer x) {
        x++;
    }


    static void modify(String x) {
        x = "hello";
    }


    static void modify(Test x) {
        x.s = "ss";
    }


    static class Test {
        private void test(){

        }

        private String s;

        public Test(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }
}

