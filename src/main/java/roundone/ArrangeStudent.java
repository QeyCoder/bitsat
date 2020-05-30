package roundone;

import roundzero.javaPrep.Array;

import java.util.*;

public class ArrangeStudent {

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {

        Collections.sort(a);
        Collections.sort(b);
        int i = 0;
        int j = 0;
        boolean startA = false;
        if (a.get(i) < b.get(j)) {
            startA = true;
            i += 1;
        } else {
            j += 1;
        }
        solve(a, b, i, j, startA);
        return "";
    }

    private static boolean solve(List<Integer> a, List<Integer> b, int i, int j, boolean startA) {
        if (i < j) {
            if(a.get(i)<a.get(j) && !startA){
                return solve(a, b, i+1, j , false);
            }
            return  false;

        } else {
            if(a.get(j)<=a.get(i) && !startA){
                return solve(a, b, i , j+1, true);
            }
            return false;
        }

    }

    public static void main(String[] args) {
        List<Integer> a= Arrays.asList(new Integer[]{2,3,5});
        List<Integer> b= Arrays.asList(new Integer[]{1,3,4});
        new ArrangeStudent().arrangeStudents(a,b);
    }
}
