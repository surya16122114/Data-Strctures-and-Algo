public class RemoveNthNodeFromTheEnd {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=findLen(head);
        int reqLen=len-n;
        //when you want to remove the first node
      if(reqLen==0)
      return head.next;
        ListNode temp=head;
        while(reqLen>1){
            temp=temp.next;
            reqLen--;
        }
        //removing the last node
        if(temp.next!=null)
        temp.next=temp.next.next;
        else
        temp.next=null;
        return head;
    }
        public int findLen(ListNode head){
        if(head==null)
        return 0;
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }

        return len;
    }
}
}
