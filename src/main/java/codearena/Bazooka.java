package codearena;

import template.FastInputReader;

/**
 * Created by Gaurav on 10/04/18.
 */

//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/oliver-and-the-battle-1/description/
public class Bazooka {


    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {


            int N = fastInputReader.readInt();
            int M = fastInputReader.readInt();
            int[][] ip = fastInputReader.readTable(N, M);

            solution(ip);
        }
    }

    private static void solution(int[][] ip) {

        int[][] duplicate = ip;
        int count = 0;
        int max = -1;
        for (int i = 0; i < ip.length; i++) {
            for (int j = 0; j < ip[0].length; j++) {
                if (duplicate[i][j] == 1) {
                    int op = killTroop(duplicate, i, j);
                    if (op > max) {
                        max = op;
                    }
                    count++;
                }
            }
        }
        System.out.println(count + " " + max);
    }

    private static int killTroop(int[][] duplicate, int i, int j) {
        int step = 0;
        if (i < 0 || i >= duplicate.length || j < 0 || j >= duplicate[0].length || duplicate[i][j] == 0) return step;

        step++;
        duplicate[i][j] = 0;
        step += killTroop(duplicate, i + 1, j);
        step += killTroop(duplicate, i, j + 1);
        step += killTroop(duplicate, i + 1, j + 1);
        step += killTroop(duplicate, i - 1, j);
        step += killTroop(duplicate, i, j - 1);
        step += killTroop(duplicate, i - 1, j - 1);
        step += killTroop(duplicate, i - 1, j + 1);
        step += killTroop(duplicate, i + 1, j - 1);
        return step;
    }


}
