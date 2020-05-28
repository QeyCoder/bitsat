package roundone;

import java.util.ArrayList;
import java.util.List;

public class Solution589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        List<Integer> ans;

        public List<Integer> preorder(Node root) {

            ans = new ArrayList<>();
            if (root != null) {
                ans.add(root.val);
                solve(root);
            }

            return ans;
        }

        private void solve(Node root) {
            if (root != null) {
                if (root.children != null) {
                    for (Node node : root.children) {

                        if (node != null) {
                            ans.add(node.val);
                            solve(node);
                        }

                    }
                }
            }
        }
    }
}
