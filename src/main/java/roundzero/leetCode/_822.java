package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 22/04/18.
 */


public class _822 {


    public static void main(String[] args) {


    }

    public int flipgame(int[] fronts, int[] backs) {

        int front = Integer.MAX_VALUE;
        int back = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {

            if (isGoodCard(fronts[i], fronts, backs)) {
                front = Math.min(front, fronts[i]);
            }
        }
        for (int i = 0; i < backs.length; i++) {
            if (isGoodCard(backs[i], fronts, backs)) {
                back = Math.min(back, backs[i]);
            }
        }
        return back != Integer.MAX_VALUE || front != Integer.MAX_VALUE ? Math.min(front, back) : 0;
    }

    private boolean isGoodCard(int input, int[] fronts, int[] backs) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == input) {
                integerList.add(i);
            }
        }

        for (int i = 0; i < integerList.size(); i++) {
            if (backs[integerList.get(i)] == input) {
                return false;

            }
        }
        return true;

    }


}
