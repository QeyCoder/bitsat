package day16;

import java.util.Scanner;

public class TimeConversion {

    static String timeConversion(String s) {
        String[] splittedData = s.split(":");
        int hr = Integer.parseInt(splittedData[0]);
        int min = Integer.parseInt(splittedData[1]);
        String sec = splittedData[2];
        int second = Integer.parseInt(sec.substring(0, 1));
        String AP = sec.substring(2, sec.length() - 1);


return null;
//pemd
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
