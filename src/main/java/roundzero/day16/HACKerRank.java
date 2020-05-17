package roundzero.day16;

import java.util.Scanner;

public class HACKerRank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        String referer = "hackerrank";
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            System.out.println(solution(referer, s));
        }
    }

    private static String solution(String referer, String s) {
        int j = 0;
        if (s.length() < referer.length()){
            return "NO";
        }
            for (int i = 0; i < s.length(); i++) {
                if(j>referer.length()-1){
                    break;
                }
                char r = referer.charAt(j);
                char ip = s.charAt(i);
                if (r == ip) {
                    j++;
                }
            }

        if (j == referer.length()) {
            return "YES";
        }
        return "NO";
    }
}
