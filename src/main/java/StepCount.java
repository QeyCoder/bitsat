/**
 * Created by Gaurav on 26/03/18.
 */


public class StepCount {

    static int[] step = {1, 2, 3};

    public static void main(String[] args) {


        System.out.println(solution(step, 6));
        System.out.println(solution(6));
    }


    private static int solution(int[] step, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < step.length; i++) {
            result += solution(step, n - step[i]);
        }
        return result;
    }


    private static int solution(int n) {


        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return solution(n - 1) + solution(n - 2) + solution(n - 3);
    }


}
