package Miscellanious;

public class AddTwoNumbers {
    class Solution {
        public int getSum(int a, int b) {
            int carry=0;
            int ans=0;
    
            for(int i=0; i<32; i++){
    //extract bits
                int aBit=(a>>i)&1;
                int bBit=(b>>i)&1;
    
                int curr=aBit^bBit^carry;
    
                carry=(aBit+bBit+carry)>=2?1:0;
    
                if(curr!=0){
    
                    //set ith bit in result to 1, if the sum is not zero and and add the curr bit to the existing result;
                    ans=ans|(1<<i);
                }
            }
    
            return ans;
            
        }
    }

   
}


