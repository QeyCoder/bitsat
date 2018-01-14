package day39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gaurav on 14/01/18.
 */
class JourneyToTheMoon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int P = Integer.parseInt(data[1]);

        LinkedList<Integer>[] adjList = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new LinkedList<>();
        }
      //  int uniqueCountry = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < P; i++) {
            data = scanner.nextLine().split(" ");
            int ast1 = Integer.parseInt(data[0]);
            int ast2 = Integer.parseInt(data[1]);
            adjList[ast1].add(ast2);
            adjList[ast2].add(ast1);
        }
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int count = dfs(visited, adjList, i, 0);
                integerList.add(count);
                //uniqueCountry++;
            }
        }

        long totalWay = 0;
        long sum = 0;
        for (Integer size : integerList) {
            totalWay += sum * size;
            sum += size;
        }

        System.out.println(totalWay);
    }

    private static int dfs(boolean[] visited, LinkedList<Integer>[] adjList, int ast, int count) {
        visited[ast] = true;
        count++;
        for (int i = 0; i < adjList[ast].size(); i++) {
            if (!visited[adjList[ast].get(i)]) {
                count = dfs(visited, adjList, adjList[ast].get(i), count);
            }
        }
        return count;
    }
}
