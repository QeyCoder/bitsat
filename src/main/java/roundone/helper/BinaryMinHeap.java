package roundone.helper;

import java.util.Map;

public class BinaryMinHeap<T> {


    //
//     Data structure to support following operations
// extracMin - O(logn)
//  addToHeap - O(logn)
//  containsKey - O(1)
//  decreaseKey - O(logn)
//  getKeyWeight - O(1)

    Map<Node, Integer> integerMap;
    class Node<T> {
        int weight;
        T key;
        public Node(T key, int weight) {
            this.key = key;
            this.weight = weight;
        }
    }

    public boolean containsKey(T data) {
        return true;
    }

    public void add(T key, int weight) {
        Node node = new Node(key, weight);




    }

    public T extracMin() {
        return null;
    }

    public void decrease() {

    }
}
