package day56;

import template.FastInputReader;
import template.MiscUtils;

/**
 * Created by Gaurav on 24/02/18.
 */


public class Maximum1Matrix {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        outer:while (T-- > 0) {

            int N = fastInputReader.readInt();
            int M = fastInputReader.readInt();

            int[][] matrix = fastInputReader.readTable(N, M);

            int[][] aux = new int[N][M];
            if(N==1 || M ==1){
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {

                        if (matrix[i][j] == 1) {
                            stringBuilder.append(1).append("\n");
                            continue outer;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                aux[i][0] = matrix[i][0];
            }
            for (int i = 0; i < M; i++) {
                aux[0][i] = matrix[0][i];
            }
            int endY = 0;
            int endX = 0;
            int max = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {

                    if (matrix[i][j] == 1) {
                        aux[i][j] = MiscUtils.min(MiscUtils.min(aux[i - 1][j], aux[i][j - 1]), aux[i - 1][j - 1]) + 1;
                        if (aux[i][j] > max) {
                            max = aux[i][j];
                            endX = i;
                            endY = j;
                        }
                    }
                }
            }

            stringBuilder.append(max).append("\n");
          /*

           to print submatrix

           for (int i = endX; i > endX - max; i--) {
                for (int j = endY; j > endY - max; j--) {
                    stringBuilder.append(matrix[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");*/


        }
        System.out.println(stringBuilder);
    }


}
