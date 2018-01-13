package day36;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

class SelvesterSequence {
    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            long prev = 2;
            StringBuilder stringBuilder =  new StringBuilder();
            stringBuilder.append(prev+" ");
            for (int j = 1; j < N; j++) {
                long no = ((prev - 1) * prev + 1)%1000000007;
                stringBuilder.append(no+" ");
                prev = no;
            }
            System.out.println(stringBuilder.toString().trim());

        }

    }
}
