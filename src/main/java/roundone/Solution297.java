package roundone;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            List<String> builder = new ArrayList<>();
            serialize(root, builder);

            StringBuilder stringBuilder =  new StringBuilder();

            for (String s : builder) {

                if(s.equals("-")) {
                    s="null";
                }
                    stringBuilder.append(s);

            }
            return stringBuilder.toString();
        }

        void serialize(TreeNode root, List<String>  builder) {
            if (root == null) {
                builder.add("-");
                return;
            }
            builder.add(String.valueOf(root.val));
            builder.add(",");
            serialize(root.left,builder);
            builder.add(",");
            serialize(root.right,builder);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] ip = data.split(",");

            return deserialize(ip,0);
        }

    private TreeNode deserialize(String[] ip, int i) {
        if(i>ip.length){
            return null;
        }
        if(ip[i+1].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ip[i+1]));
        root.left= deserialize(ip,2*i+1);
        root.right= deserialize(ip,2*i+2);
        return root;

    }

    public static void main(String[] args) {
        TreeNode treeNode =  new TreeNode(1);
        TreeNode two =  new TreeNode(2);
        TreeNode three =  new TreeNode(3);
        treeNode.left =  two;
        treeNode.right= three;
        Solution297 solution297 =  new Solution297();
//        solution297.serialize(treeNode);
        TreeNode ans = solution297.deserialize("1,2,3,null,null,4,5");
        System.out.println(ans);
    }
}