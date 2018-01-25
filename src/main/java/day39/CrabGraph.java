package day39;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Gaurav on 15/01/18.
 */
public class CrabGraph {
    public static void main(String[] args) {
        System.out.println('a'=='a');
        System.out.println('a'=='A');
        Scanner scanner = new Scanner(System.in);
        int C = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < C; i++) {
            String[] data = scanner.nextLine().split(" ");
            int N = Integer.parseInt(data[0]);
            LinkedList<Integer>[] adjList =  new LinkedList[N];
            int T = Integer.parseInt(data[1]);
            int M = Integer.parseInt(data[2]);
            for (int j = 0; j < M; j++) {
                data= scanner.nextLine().split(" ");
                int v1 = Integer.parseInt(data[0])-1;
                int v2 = Integer.parseInt(data[0])-1;

                adjList[v1].add(v2);
                adjList[v2].add(v1);
            }


        }
    }
}
