package roundzero.day36;

import java.util.*;

/**
 * Created by Gaurav on 25/12/17.
 */
//https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BFS {

    static int cost = 6;

    public static String BFS(int src, int[][] adjList) {
        StringBuilder costs = new StringBuilder();
        Map<Integer, Integer> finalCost = new TreeMap<>();
        int visited[] = new int[adjList.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                finalCost.putAll(solution(src, adjList, visited));
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                finalCost.put(i, -1);
            }
        }
        for (Integer b : finalCost.values()) {
            costs.append(b + " ");
        }
        return costs.toString().trim();

        }

    private static HashMap<Integer, Integer> solution(int src, int[][] adjList, int[] visited) {
        HashMap<Integer, Integer> finalCost = new LinkedHashMap<>();
        visited[src] = -1;
        Queue<Integer> integerQueue = new LinkedList<>();

        integerQueue.add(src);

        while (!integerQueue.isEmpty()) {
            Integer node = integerQueue.poll();
            for (int j = 0; j < adjList.length; j++) {
                if (adjList[node][j] == 1 && j != node) {
                    if(visited[j] == 0){
                        integerQueue.add(j);
                        int delta = 0;
                        if(visited[node] > 0)
                            delta = visited[node];
                        finalCost.put(j,  delta + cost);
                        visited[j] = delta + cost;
                    }
                }
            }


        }

        return finalCost;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.nextLine());
        for (int a0 = 0; a0 < q; a0++) {
            String[] data = in.nextLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);
            int[][] adjList = new int[n][n];

            for (int i = 0; i < m; i++) {
                data = in.nextLine().split(" ");
                int u = Integer.parseInt(data[0]) - 1;
                int v = Integer.parseInt(data[1]) - 1;
                adjList[u][v] = 1;
                adjList[v][u] = 1;
            }
            int S = Integer.parseInt(in.nextLine());
            System.out.println(BFS(S - 1, adjList));
        }
        in.close();


    }
}
