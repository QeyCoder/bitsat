package day7;

/**
 * Created by Gaurav on 04/10/17.
 */
public class DiceRoll {


    public static void main(String[] args) {
        DiceRoll diceRoll
                = new DiceRoll();
        System.out.println(diceRoll.getTargetCount(610));

    }

    int getTargetCount(int n) {
        // toalNumberOfWays[i] will store count of solutions for
        // value i.
        int i;
        int[] toalNumberOfWays = new int[n + 1];


        toalNumberOfWays[0] = 1;// only one dice can be roled


        for (i = 1; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 1];
        for (i = 2; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 2];
        for (i = 3; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 3];
        for (i = 4; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 4];
        for (i = 5; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 5];
        for (i = 6; i <= n; i++)
            toalNumberOfWays[i] += toalNumberOfWays[i - 6];

        return toalNumberOfWays[n];
    }

    /*//other approach would be
    int getTargetCount(int target) {

        int[] totalNoOfWay = new int[target];

        //we have to reach 0-target
        // way to reach 0- target => 0->1*1->2*2->3 ...*n-1->target
        int[][] lastElement;
        int[][] lastOfLast;
        totalNoOfWay[1] = 1;//only 1 can be use to reach
        totalNoOfWay[2] = 2;//only [0,1] and [2] can be use to reach

        for (int i = 3; i < totalNoOfWay.length; i++) {
            totalNoOfWay[i] = totalNoOfWay[i - 1] * totalNoOfWay[i - 2];
        }

        return totalNoOfWay[target];
    }*/
}
