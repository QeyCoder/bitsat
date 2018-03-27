package day62;

import template.FastInputReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gaurav on 08/03/18.
 */


public class KosarRajuGraph {

    // static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();
        Graph graph = new Graph(T);

        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {

            int i = fastInputReader.readInt();
            int j = fastInputReader.readInt();
            graph.addEdge(i, j);

        }

        boolean[] visited = new boolean[T];

        Stack<Integer> stack = new Stack<>();

        stringBuilder.append(solve(graph, visited, stack)).append("\n");
        System.out.println(stringBuilder);
    }

    private static List<List<Integer>> solve(Graph graph, boolean[] visited, Stack<Integer> stack) {
        //fill the stack

        for (int j = 0; j < visited.length; j++) {
            if (!visited[j]) {
                solution(graph, visited, stack, j);
            }
        }


        Graph transPose = getTransPose(graph);
        for (int j = 0; j < visited.length; j++) {
            visited[j] = false;
        }
/*
        List<List<Integer>>  solve = new ArrayList<>();

        while (!stack.empty()){
            List<Integer> list =  new ArrayList<>();
            Integer top = stack.pop();
            visited[top]= true;
            getSolution(transPose,stack,top,visited);
            list.add(top);

        }



*/
        return null;
    }



    private static Graph getTransPose(Graph graph) {
        Graph transPose = new Graph(graph.noOfVertex);

        for (int i = 0; i < graph.edges.length; i++) {
            for (int j = 0; j < graph.edges[i].size(); j++) {
                if (graph.getneighbour(j) != null)
                    transPose.addEdge(j, i);
            }
        }
        return transPose;
    }

    private static void solution(Graph graph, boolean[] visited, Stack<Integer> stack, int node) {
        LinkedList<Integer> neighbour = graph.getneighbour(node);
        visited[node - 1] = true;
        for (int i = 0; i < neighbour.size(); i++) {
            if (!visited[i]) {
                solution(graph, visited, stack, i);
            }
        }
        stack.push(node);
    }


    static class Graph {
        private final int noOfVertex;
        LinkedList<Integer>[] edges;

        Graph(int noOfVertex) {
            this.noOfVertex = noOfVertex;
            this.edges = new LinkedList[noOfVertex];
        }

        void addEdge(int src, int dest) {
            //reducing to maintain indexes;
            src -= 1;
            dest -= 1;
            LinkedList<Integer> sourceNode = edges[src];
            if (sourceNode == null) {
                sourceNode = new LinkedList<>();
            }

            sourceNode.add(dest);
            edges[src] = sourceNode;
        }

        public LinkedList<Integer> getneighbour(int src) {
            return edges[src];
        }
    }


}
