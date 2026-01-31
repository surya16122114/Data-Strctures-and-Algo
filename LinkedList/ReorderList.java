public class ReorderList {


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public void reorderList(ListNode head) {
        int len=findLen(head);
        int req=(len+1)/2;
       ListNode temp=head;
        while(req!=1){
            temp=temp.next;
            req--;
        }
       ListNode brokenHead=temp.next;
       temp.next=null;

       ListNode reversedHead=reverseList(brokenHead);
       ListNode curr1=head;
       ListNode next1;
       ListNode curr2=reversedHead;
       ListNode next2;

       while(curr2!=null){
        next1=curr1.next;
        next2=curr2.next;
       

        curr1.next=curr2;
        curr2.next=next1;
        curr1=next1;
        curr2=next2;
     
       }

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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)    
        return head;

        ListNode prev;
        ListNode next;
        ListNode curr=head;
prev=null;
        while(curr!=null){
                next=curr.next;

                curr.next=prev;
                prev=curr;
                curr=next;


        }

        return prev;
    }

}
}
