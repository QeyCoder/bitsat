package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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



        Stack<Node> nodes ;

        public List<Integer> preorder(Node root) {
            nodes =  new Stack<>();
            ans = new ArrayList<>();
            if (root != null) {
                nodes.add(root);
                iterative();
            }

            return ans;
        }

        private void iterative() {


            while (!nodes.empty()){
                Node item = nodes.pop();
                if(item!=null){
                    ans.add(item.val);
                    for(int i = item.children.size()-1;i>=0;i--){
                        nodes.add(item.children.get(i));
                    }
                }
            }
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
