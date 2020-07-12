package roundone;

public class Solution132 {


    public static void main(String[] args) {

        System.out.println(new Solution().minCut("leet"));
    }

    static class Solution {

        Integer[][] cutDp;
        Boolean[][] palindromDp;

        public int minCut(String s) {
            cutDp = new Integer[s.length()][s.length()];
            palindromDp = new Boolean[s.length()][s.length()];
            return cut(s, 0, s.length() - 1);
        }

        private int cut(String data, int s, int e) {
            if (s == e || isPalindrom(data, s, e)) {
                return 0;
            } else {
                if (cutDp[s][e] != null) {
                    return cutDp[s][e];
                }
                int minCut = data.length() - 1;
                for (int i = s; i <= e; i++) {
                    if (isPalindrom(data, s, i)) {
                        minCut = Math.min(minCut, 1 + cut(data, i + 1, e));
                    }
                }
                return cutDp[s][e] = minCut;
            }


        }


        boolean isPalindrom(String data, int i, int j) {
            if (i >= j) {
                return true;
            }
            if (palindromDp[i][j] != null) {
                return palindromDp[i][j];
            }

            return palindromDp[i][j] = (data.charAt(i) == data.charAt(j))
                    && isPalindrom(data, i + 1, j - 1);

        }
    }
}



