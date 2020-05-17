package roundzero.helper;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private final long id;
    List<Edge> edges = new ArrayList<>();
    List<Vertex> adjacentVertex = new ArrayList<>();

    public Vertex(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex des) {
        adjacentVertex.add(des);
        edges.add(edge);

    }

    public List<Edge> getEdges() {
        return getEdges();
    }

    public List<Vertex> getAdjacentVertex() {
        return adjacentVertex;
    }
}