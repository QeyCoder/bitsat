package roundzero.flipkart;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 14/03/18.
 */


public class SubsetDivide {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int N = fastInputReader.readInt();
            int[] data = fastInputReader.readIntArray(N);
            int x = fastInputReader.readInt();
            //stringBuilder.append(solution(data, x, 0, N - 1)).append("\n");
            stringBuilder.append(subCount(data, N, x)).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static long kSub(int k, int[] nums) {
        int sum = 0;
        long count = 0l;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum % k == 0) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int subCount(int arr[], int n, int k) {
        int aux[] = new int[k];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            aux[((totalSum % k) + k) % k]++;
        }

        int result = 0;

        for (int i = 0; i < k; i++)

            if (aux[i] > 1)
                result += ((aux[i] - 1) * aux[i]) / 2;
        result += aux[0];

        return result;
    }


    private static int solution(int[] data, int x, int sum, int N) {
        // System.out.println(sum);

        if (N < 0) {
            return 0;
        } else if (sum != 0 && sum % x == 0) {
            return 1;
        } else {
            return solution(data, x, sum + data[N], N - 1) + solution(data, x, sum, N - 1);
        }


    }
}
