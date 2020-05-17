package roundone;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1387 {

    class Tuple {
        int val;
        int index;

        public Tuple(int index, int val) {
            this.index  =  index;
            this.val =  val;
        }
    }

    public int getKth(int low, int high, int k) {
        int dp[] = new int[1000000];
        Tuple ans[] = new Tuple[high - low + 1];
        for (int i = low; i <= high; i++) {
            int rsp = solve(i, dp, 0);
            ans[i-low]= new Tuple(i,rsp);
        }

        Arrays.sort(ans, Comparator.comparingInt(o -> o.val));
        return ans[k-1].index;
    }

    private int solve(int i, int dp[], int step) {

        if (i == 1) {
            dp[i] = step;
            return dp[i];
        }
        if (i % 2 == 0) {
            dp[i] = solve(i / 2,dp,step+1);
        } else {
            dp[i] = solve(3 * i + 1,dp,step+1);
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1387().getKth(12, 15, 2));
    }
}
