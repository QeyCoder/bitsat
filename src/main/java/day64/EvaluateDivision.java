package day64;

/**
 * Created by Gaurav on 08/04/18.
 */


public class EvaluateDivision {

    static class Node {
        String m;
        String n;
    }

    public static void main(String[] args) {


        System.out.println(
                calcEquation(
                        new String[][]{
                                {"a", "b"}, {"b", "c"}
                        },
                        new double[]{2.0, 3.0},
                        new String[][]{
                                {"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
                        }));
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        return new double[0];
    }

}
