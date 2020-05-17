package day63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class Solution {

    HashMap<Integer, UndirectedGraphNode> integerUndirectedGraphNodeHashMap = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node != null) {
            if (integerUndirectedGraphNodeHashMap.containsKey(node.label)) {
                return integerUndirectedGraphNodeHashMap.get(node.label);
            }
            UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(node.label);
            integerUndirectedGraphNodeHashMap.put(node.label, undirectedGraphNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (neighbor.label != neighbor.label) {
                    undirectedGraphNode.neighbors.add(cloneGraph(neighbor));
                }
            }
            return undirectedGraphNode;
        }
        return null;
    }
}