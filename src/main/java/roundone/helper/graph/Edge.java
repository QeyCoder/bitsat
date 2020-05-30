package roundone.helper.graph;

public class Edge<T> {

    private final boolean isDirected;
    private final int weight;
    private Vertex<T> src;
    private Vertex<T> dest;


    public Edge(Vertex<T> src, Vertex<T> dest, int weight,boolean isDirected) {
        this.src = src;
        this.dest = dest;
        this.isDirected = isDirected;
        this.weight=  weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "isDirected=" + isDirected +
                ", weight=" + weight +
                ", src=" + src +
                ", dest=" + dest +
                '}';
    }
}
