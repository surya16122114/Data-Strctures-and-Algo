package BitManipulation;

public class ReverseANumber {
    class Solution {
        public int reverseBits(int n) {
            int res=0;
    
            for(int i=0; i<32; i++){
                int ithBit=(n>>i)&1;
                res=res|(ithBit<<(31-i));
            }
    
            return res;
            
        }
    }
}
