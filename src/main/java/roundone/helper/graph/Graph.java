package roundone.helper.graph;

import java.util.*;

public class Graph<T> {


    private List<Edge> edgesList;
    private final boolean isDirected;
    private final boolean isWighted;
    private Map<T, Vertex<T>> vertexMap;

    public Graph(boolean isDirected, boolean isWeighted) {
        edgesList = new ArrayList<>();
        this.isDirected = isDirected;
        this.isWighted = isWeighted;
        this.vertexMap = new HashMap<>();
    }

    public void addEdge(T src, T des, int weight) {
        Vertex<T> srcVertex;
        if (vertexMap.containsKey(src)) {
            srcVertex = vertexMap.get(src);
        } else {
            srcVertex = new Vertex<>(src);
            vertexMap.put(src, srcVertex);
        }
        Vertex<T> destVertex;
        if (vertexMap.containsKey(des)) {
            destVertex = vertexMap.get(des);
        } else {
            destVertex = new Vertex<>(des);
            vertexMap.put(des, destVertex);
        }
        Edge<T> edge = new Edge<>(srcVertex, destVertex, weight, this.isDirected);
        edgesList.add(edge);
        srcVertex.addEdge(edge, destVertex);
        if (!isDirected) {
            destVertex.addEdge(edge, srcVertex);
        }

    }

    public void addEdge(T src, T des) {
        this.addEdge(src, des, 0);
    }

    public List<Edge> getEdgesList() {
        return edgesList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean isWighted() {
        return isWighted;
    }

    public Collection<Vertex<T>> getAllVertex() {
        return vertexMap.values();
    }

    public Vertex<T> getVertex(T k) {
        return vertexMap.get(k);
    }
}
