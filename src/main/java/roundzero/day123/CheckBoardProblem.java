package roundzero.day123;

/**
 * Created by Gaurav on 30/09/17.
 */
public class CheckBoardProblem {


    public static void main(String[] args) {
        int[] dice =  new int[22];
        findSolution(21, dice, 0);

    }


    static void findSolution(int targetSum, int[] params, int position) {
        int MAX_NO = 6;
        if (targetSum == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < position; i++) {
                stringBuilder.append(params[i]);
            }
            System.out.println(stringBuilder);
        } else if (targetSum > 0) {
            for (int i = 1; i < MAX_NO; i++) {
                params[position] = i;
                findSolution(targetSum - i, params, position + 1);
            }

        }
    }
}
