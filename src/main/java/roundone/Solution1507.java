package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1507 {

    static class Solution {
        public String reformatDate(String date) {
            String[] spltd = date.split(" ");

            return new StringBuilder(spltd[2]).append("-").append(getMonth(spltd[1])).append("-").append(getDay(spltd[0])).toString();
        }

        private String getDay(String s) {
            int i = s.indexOf("th");
            if(i==-1){
                i=s.indexOf("nd");
            }
            if(i==-1){
                i=s.indexOf("st");
            }
            String op = s.substring(0, i);
            if(op.length()==1){
                return "0"+op;
            }
            return op;
        }

        private String getMonth(String s) {


            switch (s) {
                case "Jan":
                    return "01";
                case "Feb":
                    return "02";
                case "Mar":
                    return "03";
                case "Apr":
                    return "04";
                case "May":
                    return "05";
                case "Jun":
                    return "06";
                case "Jul":
                    return "07";
                case "Aug":
                    return "08";
                case "Sep":
                    return "09";
                case "Oct":
                    return "10";
                case "Nov":
                    return "11";
                case "Dec":
                    return "12";
            }
            return  s;
        }
    }

    public static void main(String[] args) {
        new Solution().reformatDate("31st Apr 2025");
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
}



