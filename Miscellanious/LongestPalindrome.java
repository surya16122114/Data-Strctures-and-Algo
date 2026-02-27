package Miscellanious;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    class Solution {
    public int longestPalindrome(String s) {

        Map<Character, Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()){
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
int ans=0;
boolean hasOdd=false;
        for(int freq: m.values()){
            ans+=(freq/2)*2;
//if it is odd
            if(hasOdd==false && freq%2==1){
                //you have to add +1 to the final answer
                hasOdd=true;
            }
        }


        return hasOdd?ans+1:ans;
 
    }
}
}
