package roundone;

public class Solution1220 {
    public static void main(String[] args) {
        new Solution().countVowelPermutation(5);
    }

    static class Solution {
        public int countVowelPermutation(int n) {


            long a = 1, e = 1, i = 1, o = 1, u = 1;

            for (int x = 0; x < n - 1; x++) {
                long a1 = e + i + u;
                long e1 = a + i;
                long i1 = e + o;
                long o1 = i;
                long u1 = i + o;
                a= (long) (a1% (1e9 + 7));
                e= (long) (e1% (1e9 + 7));
                i= (long) (i1% (1e9 + 7));
                o= (long) (o1% (1e9 + 7));
                u= (long) (u1% (1e9 + 7));
            }

            return (int) ((a + e + i + o + u) % (1e9 + 7));
        }
    }
}
