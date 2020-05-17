package roundzero.serionLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class BeautifulString {
    static long dp[][];
    static int MOD = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int n = Integer.parseInt(br.readLine().trim());

            long out_ = solution(n);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static long search(int n, int index) {

        if (dp[n][index] != 0) {
            return dp[n][index];
        } else {
            long sum = 0;
            for (int i = index; i < 5; i++) {
                sum = (sum + search(n - 1, i) % MOD) % MOD;
            }
            dp[n][index] = sum;
            return sum;
        }
    }

    static long solution(int n) {
        dp = new long[n + 1][5];
        dp[1][0] = 5;
        dp[1][1] = 4;
        dp[1][2] = 3;
        dp[1][3] = 2;
        dp[1][4] = 1;
        long result = 0;
        if (n == 1) {
            return dp[1][0];
        } else {
            result = search(n, 0) % MOD;
        }
        return (long) result;
    }
}