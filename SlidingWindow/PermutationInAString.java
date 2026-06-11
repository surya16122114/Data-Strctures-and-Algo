package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> target=new HashMap<>();

        Map<Character, Integer> window=new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i) ,0)+1);
        }

        int right=0;
        int left=0;

        while(right<s2.length()){
            char ch=s2.charAt(right);

                window.put(ch, window.getOrDefault(ch,0)+1);

              

                while(right-left+1>s1.length()){
                    window.put(s2.charAt(left), window.get(s2.charAt(left))-1);
                    if(window.get(s2.charAt(left))==0)
                    window.remove(s2.charAt(left));

                    left++;

                    
                }
                  if(window.equals(target)){
                    return true;
                }


                right++;

        }

        return false;
        
    }
}
}

//leetcode problem link : https://leetcode.com/problems/permutation-in-string/description/