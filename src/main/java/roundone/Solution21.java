package roundone;

public class Solution21
{
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
            ListNode head=null;

            if(l1.val< l2.val){
                head=l1;
                l1=l1.next;
            }else{
                head=l2;
                l2=l2.next;
            }
            ListNode tmp=head;

            while(l1!=null && l2!=null){
                if(l1.val< l2.val){
                    head.next=l1;
                    l1=l1.next;
                    head =head.next;
                }else{
                    head.next=l2;
                    l2=l2.next;
                    head =head.next;
                }
            }
            while(l1!=null){

                head.next=l1;
                l1=l1.next;
                head =head.next;
            }
            while(l2!=null){

                head.next=l2;
                l2=l2.next;
                head =head.next;
            }
            return tmp;

        }
    }
    public static void main(String args[]) {
        Solution solution = new Solution();
    }
}
