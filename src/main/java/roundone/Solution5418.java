package roundone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution5418 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            if (root == null) return 0;
            StringBuilder sb = new StringBuilder();
            helper(sb, root);
            return ans;
        }

        int ans = 0;

        public boolean checkAns(String ans) {
            Map<String, Long> maping = Arrays.stream(ans.split(",")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            int odd = 0;
            for (Long aLong : maping.values()) {
                if (aLong % 2 != 0) odd++;
            }
            return odd <= 1;
        }

        public void helper(StringBuilder sb, TreeNode root) {
            if (root == null) return;
            int tmp = sb.length();
            if (root.left == null && root.right == null) {
                sb.append(root.val);
                if (checkAns(sb.toString())) {
                    ans++;
                }
                sb.delete(tmp, sb.length());
                return;
            }
            sb.append(root.val + ",");
            helper(sb, root.left);
            helper(sb, root.right);
            sb.delete(tmp, sb.length());
            return;

        }
    }
//
//    static class Solution1 {
//        public int pseudoPalindromicPaths(TreeNode root) {
//            List<Integer> path = new ArrayList<>();
//            return printPath(root, path);
//        }
//
//        public int printPath(TreeNode root, List<Integer> path) {
//
//            if (root == null) {
//                return 0;
//            }
//            path.add(root.val);
//            if (root.left == null && root.right == null) {
//                if (checkAns(path)) {
//                    return 1;
//                }
//            }
//            return printPath(root.left, path) + printPath(root.right, path);
//
//        }
//
//        public boolean checkAns(List<Integer> ans) {
//            Map<Integer, Long> maping = ans.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//            int odd = 0;
//            for (Long aLong : maping.values()) {
//                if (aLong % 2 != 0) odd++;
//            }
//            ans.remove(ans.size() - 1);
//            return odd <= 1;
//        }
//
//    }

    public static void main(String[] args) {
        Solution solution
                = new Solution();
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(solution.pseudoPalindromicPaths(root));
    }
}
