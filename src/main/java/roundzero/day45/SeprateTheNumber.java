package roundzero.day45;

import java.util.Scanner;

public class SeprateTheNumber {

    static String separateNumbers(String data,
                                  int i) {
        if ((data.length())/2+1 == i) {
            return "-1";
        }

        long min = Long.parseLong(data.substring(0, i));
        long dataToBe = min;

        StringBuilder temp = new StringBuilder();
        temp = temp.append(min);
        int x = 0;
        while (temp.length() < data.length()) {
            temp = temp.append(++min);
        }
        if (temp.toString().equals(data)) {
            return Long.toString(dataToBe);
        }
        return separateNumbers(data, i + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            String op = separateNumbers(s, 1);
            System.out.println(op.equals("-1") ? "NO" : op.equals(s) ? "NO" : "YES " + op);
        }
        in.close();
    }
}
