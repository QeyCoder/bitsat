package roundone.helper;

import roundone.helper.graph.Graph;
import roundone.helper.graph.Vertex;

import java.util.*;

public class TopologicalSort<T> {

    private final Graph<T> graph;

    private Stack<Vertex<T>> stack;
    private Set<Vertex<T>> visited;

    public TopologicalSort(Graph<T> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
        this.visited = new HashSet<>();
    }


    public List<Vertex<T>> sort() {
        for (Vertex<T> tVertex : graph.getAllVertex()) {
            if (!visited.contains(tVertex)) {
                sortUtil(tVertex);
            }
        }
        List<Vertex<T>> sortedElement = new ArrayList<>();
        while (!stack.empty()) {
            sortedElement.add(stack.pop());
        }
        return sortedElement;
    }

    private void sortUtil(Vertex<T> vertex) {
        visited.add(vertex);
        for (Vertex<T> vrtx : vertex.getAdjacentVertex()) {
            if (!visited.contains(vrtx)) {
                sortUtil(vrtx);
            }
        }
        stack.add(vertex);
    }
}
