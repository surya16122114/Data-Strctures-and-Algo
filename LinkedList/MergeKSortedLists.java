

public class MergeKSortedLists {
 

 public class ListNode {
    int val;
  ListNode next;
   ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode temp1=new ListNode(-1);
        ListNode temp2=temp1;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp2.next=new ListNode(list1.val);
                temp2=temp2.next;
                list1=list1.next;
            }
            else{
                temp2.next=new ListNode(list2.val);
                temp2=temp2.next;
                list2=list2.next;
            }
        }

        while(list1!=null){
             temp2.next=new ListNode(list1.val);
                temp2=temp2.next;
                list1=list1.next;
        }
        while(list2!=null){
              temp2.next=new ListNode(list2.val);
                temp2=temp2.next;
                list2=list2.next;
        }

        return temp1.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode answer=lists[0];
        for(int i=1; i<lists.length; i++)
        answer=mergeTwoLists(answer,lists[i]);
        return answer;
    }
}
}
