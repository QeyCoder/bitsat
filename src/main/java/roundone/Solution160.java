package roundone;

import java.util.HashSet;
import java.util.Set;

public class Solution160 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            Set<ListNode> storage = new HashSet<>();
            while(headA!=null){
                storage.add(headA);
                headA= headA.next;
            }

            while(headB!=null){
                if(storage.contains(headB)){
                    return headB;
                }
                headB= headB.next;
            }
            return null;

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
