package roundone;

public class Solution5188 {
    static class TreeAncestor {
        private final int n;
        int[] parent;

        public TreeAncestor(int n, int[] parent) {
            this.parent = parent;
            this.n =n;
        }

        public int getKthAncestor(int node, int k) {
            if(node>=n){
                return -1;
            }
            while (k-- > 0) {
                if (node == -1) {
                    break;
                }
                node = parent[node];
            }
            return node;

        }
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(3, new int[]{-1, 0, 0, 1});

        treeAncestor.getKthAncestor(3, 1);  // returns 1 which is the parent of 3
        treeAncestor.getKthAncestor(5, 2);  // returns 0 which is the grandparent of 5
        treeAncestor.getKthAncestor(6, 3);  // returns -1 because there is no such ancestor
    }
}
