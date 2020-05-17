package roundzero;import java.util.Scanner;

/**
 * Created by Gaurav on 15/03/18.
 */


public class TelephoneDir {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int len = Integer.parseInt(scanner.nextLine());
            String[] strings = new String[len];
            for (int l = 0; l < len; l++) {
                strings[l] = scanner.nextLine();
            }
            if (solution(strings)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean solution(String[] strings) {


        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (i!=j && check(strings[i], strings[j])) {
                    return false;
                }

            }
        }
        return true;
    }

    private static boolean check(String a, String b) {
        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }


}
