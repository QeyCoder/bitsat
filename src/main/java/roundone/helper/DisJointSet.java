package roundone.helper;

import java.util.HashMap;
import java.util.Map;

public class DisJointSet<E> {

    class Node<E> {
        E data;
        int rank;
        Node parent;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "parent::"+ parent.data;
        }
    }

    Map<E, Node> nodeMap = new HashMap<>();


    public void make(E data) {
        if(nodeMap.get(data)!=null){
            return;
        }
        Node node = new Node(data);
        node.rank = 0;
        node.parent = node;
        nodeMap.put(data, node);
    }

    public boolean union(E a, E b) {

        Node A = nodeMap.get(a);
        Node B = nodeMap.get(b);

        Node parentA = find(A);
        Node parentB = find(B);
        if (parentA.data == parentB.data) {
            return false;
        } else {
            if (parentA.rank >= parentB.rank) {
                parentA.rank = (parentA.rank == parentB.rank) ? parentA.rank + 1 : parentA.rank;
                parentB.parent = parentA;
            } else {
                parentA.parent = parentB;
            }
            return true;
        }

    }


    private E find(E data) {
        return find((E) nodeMap.get(data).data);
    }

    private Node find(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        return find(parent);
    }


}
