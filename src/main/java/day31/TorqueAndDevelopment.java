package day31;

import java.util.LinkedList;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/torque-and-development/problem
 class TorqueAndDevelopment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < q; i++){
            long totalCost = 0;
            String[] data = scanner.nextLine().split(" ");

            int noOfCities = Integer.parseInt(data[0]);
            int noOfRoads = Integer.parseInt(data[1]);
            long libCost = Long.parseLong(data[2]);
            long roadCost = Long.parseLong(data[3]);

            LinkedList<Integer>[] graph = new LinkedList[noOfCities];
            boolean[] visited = new boolean[noOfCities];
            if (roadCost >= libCost || noOfRoads == 0) {
                totalCost = libCost * noOfCities;
                for (int j = 0; j < noOfRoads; j++) {
                    scanner.nextLine();
                    // do nothing
                }
            } else {
                int connectingRoad = 0;
                for (int j = 0; j < noOfRoads; j++) {
                    data = scanner.nextLine().trim().split(" ");
                    int city_1 = Integer.parseInt(data[0]);
                    int city_2 = Integer.parseInt(data[1]);
                    if (graph[city_1 - 1] == null) {
                        graph[city_1 - 1] = new LinkedList<>();
                    }
                    if (graph[city_2 - 1] == null) {
                        graph[city_2 - 1] = new LinkedList<>();
                    }
                    graph[city_1 - 1].add(city_2 - 1);
                    graph[city_2 - 1].add(city_1 - 1);
                    //all edges have same weight

            }
                for (int j = 0; j < noOfCities; j++) {
                    if (visited[j] == false) {
                        dfs(visited, graph, j);
                        connectingRoad++;
                    }
                }
                totalCost = (noOfCities - connectingRoad) * roadCost + libCost * connectingRoad;
            }
            System.out.println(totalCost);


        }

    }

    private static void dfs(boolean[] visited, LinkedList<Integer>[] graph, int city) {
        visited[city] = true;
        for (int i = 0; graph[city] != null && i < graph[city].size(); i++) {
            if (!visited[graph[city].get(i)]) {
                dfs(visited, graph, graph[city].get(i));
            }

        }


    }


}
