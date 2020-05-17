package day63;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Gaurav on 05/04/18.
 */


public class ProperFunction {


    public static void main(String[] args) {


        Scanner fastInputReader = new Scanner(System.in);
        int T = Integer.parseInt(fastInputReader.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = Integer.parseInt(fastInputReader.nextLine());
            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {

                strings[i] = fastInputReader.nextLine();
            }

            strings = solution(strings);

            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
            }
        }
    }

    private static String[] solution(String[] strings) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.equalsIgnoreCase(o2)) {
                    if (o1.toUpperCase().equals(o1) && o2.toUpperCase().equals(o2)) {
                        return o1.compareTo(o2);
                    } else if (o1.toUpperCase().equals(o1)) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if(o1.contains(" ")&& !o2.contains(" ")){
                        return 1;
                    }
                    if(o2.contains(" ")&& !o1.contains(" ")){
                        return -1;
                    }
                }
                return o2.compareTo(o1);

            }
        });
        return strings;
    }


}
