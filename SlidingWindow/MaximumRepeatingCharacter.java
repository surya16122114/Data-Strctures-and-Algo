package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumRepeatingCharacter {
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m=new HashMap<>();

     

        int left=0;
        int right=0;
        int len=0;
        int n=s.length();

        while(right<n){

            m.put(s.charAt(right), m.getOrDefault(s.charAt(right),0)+1);

            while(m.get(s.charAt(right))>1){
                m.put(s.charAt(left), m.get(s.charAt(left))-1);
                left++;
            }

            len=Math.max(len, right-left+1);

            right++;
        }

        return len;
    }
}
}
