package leetCode;

/**
 * Created by Gaurav on 29/04/18.
 */


public class _746 {

    public int minCostClimbingStairs(int[] cost) {

        return minCost(cost, cost.length - 1);

    }

    private int minCost(int[] cost, int i) {
        int f0 = cost[0];
        int f1 = cost[1];
        int f2 = 0;
        for (int j = 2; j < cost.length; j++) {
            f2 = cost[j] + Integer.min(f1, f0);
            f0 = f1;
            f1 = f2;
        }
        return Integer.min(f1,f0);

    }


    public static void main(String[] args) {
        _746 ref = new _746();
        System.out.println(ref.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(ref.minCostClimbingStairs(new int[]{10, 15, 20}));

    }

}
