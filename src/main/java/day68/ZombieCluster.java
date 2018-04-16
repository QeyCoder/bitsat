package day68;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaurav on 15/04/18.
 */


public class ZombieCluster {


    static int zombieCluster(String[] zombies) {
        int count = 0;
        DisJointSet<Integer> integerDisJointSet = new DisJointSet<>();

        for (int i = 0; i < zombies.length; i++) {
            String[] splttd = zombies[i].split("");
            for (int j = 0; j < splttd.length; j++) {
                if (i == j) {
                    String ip = splttd[j];
                    if (ip.equals("1")) {
                        integerDisJointSet.makeSet(i);
                        integerDisJointSet.makeSet(j);
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < zombies.length; i++) {
            String[] splttd = zombies[i].split("");
            for (int j = 0; j < splttd.length; j++) {
                String ip = splttd[j];
                if (ip.equals("1")) {
                    if (i != j) {
                        boolean result = integerDisJointSet.union(i, j);
                        if (result) {
                            count--;
                        }
                    }
                }

            }
        }

        return count;
    }


    static class DisJointSet<T> {


        class Node<T> {
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

    public static void main(String[] args) {
        System.out.println(zombieCluster(new String[]{
                "111", "111", "111"
        }));
        System.out.println(zombieCluster(new String[]{
                "000", "000", "000"
        }));
        System.out.println(zombieCluster(new String[]{
                "10000", "01000", "00100", "00010", "00001"
        }));
        System.out.println(zombieCluster(new String[]{
                "1100", "1110", "0110", "0001"
        }));
    }


}
