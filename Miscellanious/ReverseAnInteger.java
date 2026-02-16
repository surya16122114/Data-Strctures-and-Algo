package Miscellanious;

public class ReverseAnInteger {
    class Solution {
        public int reverse(int x) {
            int MIN=-2147483648;
            int MAX=2147483647;
        int ans=0;
            while(x!=0){
    
                int digit=x%10;
                x=x/10;
    
                if(ans > MAX/10 || (ans == MAX/10 && digit > 7))
        return 0;
    if(ans < MIN/10 || (ans == MIN/10 && digit < -8))
        return 0;
    
                ans=(ans*10)+digit;
            }
    
            return ans;
            
        }
    }
}
