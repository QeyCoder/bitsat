package roundzero.day16;

import java.util.Scanner;

public class Grade {

    static int[] solve(int[] grades) {


        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 38) {
                //do nothing
            } else {
                int no = grades[i];
                int nextMultiple = (no / 10) * 10;
                int remainder = no % 10;

                if (remainder >= 5) {
                    nextMultiple = nextMultiple + 10;
                } else {
                    nextMultiple = nextMultiple + 5;
                }
                int diff = nextMultiple - no;
                if (diff < 3) {
                    grades[i] = nextMultiple;
                }
            }
        }
        return grades;
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
