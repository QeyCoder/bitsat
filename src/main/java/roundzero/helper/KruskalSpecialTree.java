package roundzero.helper;


import java.util.*;

class KruskalSpecialTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        Graph<Integer> graph = new Graph(false);
        for (int i = 0; i < m; i++) {
            data = in.nextLine().split(" ");
            int sN = Integer.parseInt(data[0]);
            int dN = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);
            graph.addEdge(sN, dN, w);

        }
        long count = 0;
        for (Edge<Integer> integerEdge : solution(graph)) {
            count += integerEdge.getWeight();
        }
        System.out.println(count);
    }

    private static List<Edge<Integer>> solution(Graph<Integer> graph) {
        List<Edge<Integer>> edges = graph.getEdgeList();
        GraphComparator graphGraphComparator = new GraphComparator();
        edges.sort(graphGraphComparator);
        DisJointSet disJointSet = new DisJointSet();
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            disJointSet.makeSet(vertex.getId());
        }
        List<Edge<Integer>> resultSet = new ArrayList<>();
        for (Edge<Integer> edge : edges) {


            long srcR = (long) disJointSet.findSet(edge.getSrc().getId());
            long destR = (long) disJointSet.findSet(edge.getDest().getId());

            if (srcR == destR) {
                continue;
            } else {
                resultSet.add(edge);
                disJointSet.union(srcR, destR);
            }

        }
        return resultSet;


    }


    private static class GraphComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> o1, Edge<Integer> o2) {
            if (o1.getWeight() < o2.getWeight()) {
                return -1;
            } else if (o1.getWeight() > o2.getWeight()) {
                return 1;
            } else {
                long w1 = o1.getSrc().getId() + o1.getDest().getId() + o1.getWeight();
                long w2 = o2.getSrc().getId() + o2.getDest().getId() + o2.getWeight();
                if (w1 > w2) {
                    return 1;
                } else if (w2 > w1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }



    static class Edge<T> {
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
            return "src" + src + "des" + dest;
        }
    }

    static class Vertex<T> {
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

    static class Graph<T> {
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
            Vertex src ;
            if (vertexMap.containsKey(s)) {
                src = vertexMap.get(s);
            } else {
                src = new Vertex(s);
                vertexMap.put(s, src);
            }
            Vertex des;
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

    static class DisJointSet<T> {


        static class Node<T> {
            T data;
            int rank;
            Node parent;

        }

        Map<T, Node> nodeMap = new HashMap<>();

        public void makeSet(T data) {
            Node node = new Node();
            node.data = data;
            node.rank = 0;
            node.parent = node;
            nodeMap.put(data, node);
        }

        public boolean union(T a, T b) {

            Node A = nodeMap.get(a);
            Node B = nodeMap.get(b);


            Node parentA = findSet(A);
            Node parentB = findSet(B);
            if (parentA.data == parentB.data) {
                return false;
            }

            if (parentA.rank >= parentB.rank) {
                parentA.rank = (parentA.rank == parentB.rank) ? parentA.rank + 1 : parentA.rank;
                parentB.parent = parentA;
            } else {
                parentA.parent = parentB;
            }
            return true;

        }

        public T findSet(long data) {
            return (T) findSet(nodeMap.get(data)).data;
        }

        /**
         * Find the representative recursively and does path
         * compression as well.
         */
        private Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node) {
                return parent;
            }
            parent = findSet(parent);
            return parent;
        }

    }
}
