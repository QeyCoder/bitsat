package roundzero.day36;

import java.util.Scanner;

public class Solution {

    static void initialize(String s) {
        // This function is called once before all queries.
    }

    static int answerQuery(String str) {

        	int N = str.length();

		int[][] cps = new int[N+1][N+1];
		for (int i = 0; i < N; i++)
			cps[i][i] = 1;
	
		
		for (int L=2; L<=N; L++)
		{
			for (int i = 0; i < N; i++)
			{
				int k = L + i - 1;
				if (k < N){
				if (str.charAt(i) == str.charAt(k))
					cps[i][k] = cps[i][k-1] + cps[i+1][k] + 1;
				else
					cps[i][k] = cps[i][k-1] + cps[i+1][k] -cps[i+1][k-1] ;
				}
			}
		}
		return cps[0][N-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(s.substring(l+1,r));
            System.out.println(result);
        }
        in.close();
    }
}