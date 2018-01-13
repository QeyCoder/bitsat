
package helper;

public class Edge<T> {
    private final boolean isDirected;
    private Vertex<T> src;
    private Vertex<T> dest;
    private long weight;

    public Edge(Vertex src, Vertex des, long weight, boolean isDirected) {
        this.src = src;
        this.dest = des;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    public Vertex<T> getSrc() {
        return src;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public long getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "src"+src+"des"+dest;
    }
}