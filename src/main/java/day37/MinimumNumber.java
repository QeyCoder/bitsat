package day37;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class MinimumNumber {
    public static void main(String args[] ) throws Exception {
        
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int A = Integer.parseInt(data[1]);
            int K = Integer.parseInt(data[2]);
            int[] input =  new int[N];
            String[] inputD = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                input[j] =  Integer.parseInt(inputD[i]);

            }
            solution(input, A, K);
        }


       

    }

    private static void solution(int[] input, int a, int k) {

    }
}
