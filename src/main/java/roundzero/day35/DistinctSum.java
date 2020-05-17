package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class DistinctSum {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casse = Integer.parseInt(br.readLine());
        for (int i = 0; i < casse; i++) {

            String[] data = br.readLine().split(" ");


            System.out.println(solution(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }


    }

    private static int solution(int N, int K) {

        if (K == 0) {
            return 1;
        }
        return (solution(N, K - 1)+N/K)%
                1000000007;
    }

}
