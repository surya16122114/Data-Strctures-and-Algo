package Miscellanious;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s=new HashSet<>();

        while(!s.contains(n)){
            s.add(n);
            n=happyNumber(n);

            if(n==1)
            return true;

        }


        return false;
    }



    public int happyNumber(int n){
        int res=0;
        while(n!=0){
            int digit=n%10;
           res+= digit*digit;
           n=n/10;
        }

        return res;
    }
}
}
