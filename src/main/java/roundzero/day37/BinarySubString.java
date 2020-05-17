package roundzero.day37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 07/01/18.
 */
public class BinarySubString {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader
                 =  new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        List<String> op = subString(str, str.length());
      //  System.out.println(op);

        int count = 0;
        for (String s : op) {
            s = removeZero(s);
            if(s.charAt(s.length()-1) =='1'){
                count++;
            }
        }
        System.out.println(count);
    }

    public static List<String> subString(String str, int n) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String op = str.substring(i, j);
                strings.add(op);
            }
        }
        return strings;
    }

    public static String removeZero(String str) {
        // Count trailing zeros
        int i = str.length()-1;
        while (str.charAt(i) == '0' && i>0) {
            i--;
        }

        // Convert str into StringBuffer as Strings
        // are immutable.
        StringBuffer sb = new StringBuffer(str);

        // The  StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(i+1, str.length(), "");

        return sb.toString();  // return in String
    }
   /* public static void main(String[] args) throws IOException {
        removeZero("110");
    }*/
}
