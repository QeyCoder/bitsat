package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/challenge/hiring/servicenow-developer-hiring-challenge/problems/a1fcebe7760e49c9b35b140da0ce23e5/
class TheFlightPlan {
    public static void main(String args[]) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        //time to shuffle
        int T = Integer.parseInt(data[2]);
        //time taken for flight

        int C = Integer.parseInt(data[3]);
        int[][] cityMap=  new int[N][N];
        for (int i = 0; i < M; i++) {
            String[] data1 = br.readLine().split(" ");
            int U = Integer.parseInt(data1[0]);
            int V = Integer.parseInt(data1[1]);
            cityMap[U][V]=1;
        }
        String[] data2 = br.readLine().split(" ");
        int X = Integer.parseInt(data2[0]);
        int Y = Integer.parseInt(data2[1]);

    }
}
