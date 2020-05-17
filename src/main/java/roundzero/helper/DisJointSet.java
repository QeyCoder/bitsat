package roundzero.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 05/01/18.
 */
public class DisJointSet<T> {


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
        node.parent =  node;
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
