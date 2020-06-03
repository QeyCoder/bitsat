package roundone;

public class Solution19
{
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            if(head==null){
                return null;
            }


            ListNode slwNode= dummy;
            ListNode fastNode= dummy;

            while(n-->=0){
                fastNode = fastNode.next;
            }

            while(fastNode!=null){
                fastNode = fastNode.next;
                slwNode=  slwNode.next;
            }

            slwNode.next=slwNode.next.next;
            return dummy.next;

        }
    }
    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
