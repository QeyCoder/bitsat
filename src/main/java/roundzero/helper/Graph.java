package roundzero.helper;

import java.util.*;

public class Graph<T> {
    private List<Edge<T>> edgeList;
    private Map<Long, Vertex<T>> vertexMap;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        edgeList = new ArrayList<>();
        vertexMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(long src, long dest) {
        addEdge(src, dest, 0);
    }

    public Vertex<T> getVertex(long node) {
        return vertexMap.get(node);

    }

    void addVertex(Vertex<T> vertex) {
        if (vertexMap.containsKey(vertex)) {
            return;
        }
        vertexMap.put(vertex.getId(), vertex);

        for (Edge<T> edge : vertex.getEdges()) {
            edgeList.add(edge);
        }
    }

    public void addEdge(long s, long d, int weight) {
        Vertex src = null;
        if (vertexMap.containsKey(s)) {
            src = vertexMap.get(s);
        } else {
            src = new Vertex(s);
            vertexMap.put(s, src);
        }
        Vertex des = null;
        if (vertexMap.containsKey(d)) {
            des = vertexMap.get(d);
        } else {
            des = new Vertex(d);
            vertexMap.put(d, des);
        }

        Edge<T> edge = new Edge<>(src, des, weight, isDirected);
        edgeList.add(edge);
        src.addAdjacentVertex(edge, des);
        if (!isDirected) {
            des.addAdjacentVertex(edge, src);
        }
    }

   public Collection<Vertex<T>> getAllVertex() {
        return vertexMap.values();

    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }
}