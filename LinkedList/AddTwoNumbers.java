

public class AddTwoNumbers {

 public class ListNode {
    int val;
  ListNode next;
  

   ListNode(int val) { this.val = val; }
   
   
   
 }
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           ListNode dummy=new ListNode(-1);
           ListNode temp=dummy;
    int carry=0;
           while(l1!=null ||l2!=null || carry!=0){
              int number1;
              int number2;
            if(l1!=null){
                number1=l1.val;
            }
            else{
                number1=0;

            }
            if(l2!=null){
                number2=l2.val;
            }
            else{
                number2=0;
                
            }

            int sum=number1+number2+carry;
            int digitInSum=sum%10;
            carry=sum/10;

            ListNode newNode=new ListNode(digitInSum);
            temp.next=newNode;
            temp=temp.next;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
           }
           return dummy.next;



        
    }

     
}


}
