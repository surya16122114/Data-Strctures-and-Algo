package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;

        //the trick is to think of the max frequency

        //window is valid unless windowsize<=maxfreq+k

    int res=0;
    int maxFreq=0;
    Map<Character, Integer> m=new HashMap<>();
    int n=s.length();
        while(right<n){
            char ch=s.charAt(right);
            m.put(ch, m.getOrDefault(ch, 0)+1);

            maxFreq=Math.max(maxFreq, m.get(ch));


            //shrink the window
           
            while(right-left+1 >maxFreq+k){
                char temp=s.charAt(left);
                m.put(temp, m.get(temp)-1);

                left++;
            }
       
            res=Math.max(right-left+1, res);

            right++;

        }

        return res;
    }
}

//leetcode problem link : https://leetcode.com/problems/longest-repeating-character-replacement/description/

    
}
