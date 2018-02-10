package monoceptHiring;

import template.FastInputReader;

/**
 * Created by Gaurav on 10/02/18.
 */
public class SpecialSubString {

    public static void main(String[] args) {
        FastInputReader fastInputReader
                = new FastInputReader();
        String data = fastInputReader.readString();

        long count = 0;
        for (int i = 0; i <= data.length(); i++) {
            for (int j = i + 1; j <= data.length(); j++) {
                count += getCount(data.substring(i, j));
            }
        }

        System.out.println(count);
    }

    static int getCount(String data) {


        if (checkForHash(data)) {
            return 1;
        } else {
            if (checkForMidHash(data)) {
                return 1;
            }


        }
        return 0;


    }

    private static boolean checkForHash(String str) {
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != tmp) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForMidHash(String str) {
        if (str.length() % 2 != 0) {

            char s = str.charAt(0);
            char e = str.charAt(str.length() - 1);
            char mid = str.charAt((int) Math.ceil(str.length() / 2));
            int st = 0;
            int en = str.length() - 1;
            while (s == e && st != en) {
                st++;
                en--;
                s = str.charAt(st);
                e = str.charAt(en);
            }
            if (en - st > 1) {
                return false;
            }
            return true;

        }
        return false;
    }
}
