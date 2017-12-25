package day31;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/torque-and-development/problem
 class TorqueAndDevelopment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            int n = in.nextInt();
            int[][] cities =  new int[n][n];
            int m = in.nextInt();
            long libCost = in.nextLong();
            long roadCost = in.nextLong();
            for(int j = 0; j < m; j++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                cities[city_1-1][city_2-1] = 1;
            }
        solution(cities, libCost,roadCost);
        }

    }

    private static void solution(int[][] cities, long libCost, long roadCost) {

    }
}
