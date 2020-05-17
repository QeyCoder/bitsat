package roundzero.day36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/joker-and-thieves-53e59f4a/
class PoliceAndTheif {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] line = br.readLine().split(" ");

            int N=0;
            int K=0;
            try {
                N = Integer.parseInt(line[0]);
                K = Integer.parseInt(line[1]);
                char[][] A = new char[N][N];
                for (int i_A = 0; i_A < N; i_A++) {
                    String[] arr_A = br.readLine().split(" ");
                    for (int j_A = 0; j_A < arr_A.length; j_A++) {
                        A[i_A][j_A] = arr_A[j_A].charAt(0);
                    }
                }

                int out_ = solution(A, K);
                System.out.println(out_);
                System.out.println("");
            } catch (Exception e) {
                System.out.println("0");
            }


        }

        br.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }

    static int solution(char[][] A, int K) {
        int N = A.length;
        int count = 0;
        List<Pair> police = new ArrayList<>();
        List<Pair> theifs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 'P') {
                    police.add(new Pair(i, j));
                } else {
                    theifs.add(new Pair(i, j));
                }
            }
        }

        for (Pair pair : police) {

            Integer x = pair.x;
            Integer y = pair.y;
            //check left k times;
            //check right k times;
            for (int i = K; i >= 0; i--) {
                //do nothing
                if (y - i < 0) {
                } else {
                    if (A[x][y - i] == 'T' && A[x][y] == 'P') {
                        A[x][y] = '-';
                        A[x][y - i] = '-';
                        count++;
                    }
                }
            }


            for (int i = K; i >= 0; i--) {
                //do nothing
                if (y + i > N - 1) {

                } else {
                    if (A[x][y + i] == 'T' && A[x][y] == 'P') {
                        A[x][y] = '-';
                        A[x][y + i] = '-';
                        count++;

                    }
                }

            }

        }


        return count;

    }
}