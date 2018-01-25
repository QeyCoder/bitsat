package day40;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Gaurav on 15/01/18.
 */
public class SynchronousShopping {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);
        int K = Integer.parseInt(data[2]);

        LinkedList<Integer>[] adjList = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int i = 0; i < N; i++) {
            data = scanner.nextLine().split(" ");
            int T = Integer.parseInt(data[0]);
        }
    }
}
