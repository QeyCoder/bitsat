package roundzero.day16;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Array {


    /*
     * Complete the function below.
     */
    static int minimumMoves(int[] a, int[] m) {

        int stepRequired = 0;
        for (int i = 1; i < a.length; i++) {
            int first = a[i];
            int second = m[i];


            int diff = second - first;
            stepRequired(diff);

        }
        return stepRequired;


    }

    private static void stepRequired(int diff) {
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        int[] a = new int[a_size];
        for (int i = 0; i < a_size; i++) {
            int a_item;
            a_item = Integer.parseInt(in.nextLine().trim());
            a[i] = a_item;
        }

        int m_size = 0;
        m_size = Integer.parseInt(in.nextLine().trim());

        int[] m = new int[m_size];
        for (int i = 0; i < m_size; i++) {
            int m_item;
            m_item = Integer.parseInt(in.nextLine().trim());
            m[i] = m_item;
        }

        res = minimumMoves(a, m);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}