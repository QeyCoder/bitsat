package roundone;

public class Solution237 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
