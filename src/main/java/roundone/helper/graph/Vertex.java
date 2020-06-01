package roundone.helper.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {

    private final T val;
    private List<Edge> edges = new ArrayList<>();
    private List<Vertex> adjacentVertex = new ArrayList<>();

    public Vertex(T val) {
        this.val = val;
    }


    public void addEdge(Edge<T> edge, Vertex<T> dest) {
        edges.add(edge);
        adjacentVertex.add(dest);
    }

    public T getVal() {
        return val;
    }

    public List<Vertex> getAdjacentVertex() {
        return adjacentVertex;
    }

    public void setAdjacentVertex(List<Vertex> adjacentVertex) {
        this.adjacentVertex = adjacentVertex;
    }

    @Override
    public String toString() {
        return "Vertex{" + val + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Vertex<?> vertex = (Vertex<?>) o;
        return val == vertex.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
