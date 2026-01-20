package DataStructuresAndAlgo.Arrays;

import java.util.HashMap;
import java.util.Map;

class validAnagram{
    class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())
       return false;

       Map<Character, Integer> freq=new HashMap<>();

       for(int i=0; i<s.length(); i++){
        freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
       }

       for(int i=0; i<t.length(); i++){
        if(!freq.containsKey(t.charAt(i)) || freq.get(t.charAt(i))==0)
        return false;

        freq.put(t.charAt(i), freq.get(t.charAt(i))-1);
       }


       return true;
      
    }
}
}


//O(n) time and O(1) space solution
//leetcode problem link: https://leetcode.com/problems/valid-anagram/description/
//The idea is to use a frequency map to count the occurrences of each character in the first string.
//Then, we iterate through the second string and decrement the count for each character.
//If we encounter a character that is not in the map or its count becomes negative, we return false.
//If we successfully process all characters in the second string, we return true.   