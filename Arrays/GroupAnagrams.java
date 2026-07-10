import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
    class Solution {
        public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<String>> res = new ArrayList<>();
    
        for(int i = 0; i < n; i++) {  
            if(visited[i])
                continue;
            
            ArrayList<String> li = new ArrayList<>();
            li.add(strs[i]);  
            visited[i] = true;
            
            for(int j = i + 1; j < n; j++) { 
                if(!visited[j] && isAnagram(strs[i], strs[j])) {
                    visited[j] = true;
                    li.add(strs[j]);
                }
            }
            
            res.add(li);
        }
        return res;
    }
    
    
        public boolean isAnagram(String s, String t) {
           if(s.length()!=t.length())
           return false;
    
           HashMap<Character, Integer> freq=new HashMap<>();
    
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

//more optimised solution
//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//
//        Map<String, List<String>> m=new HashMap<>();
//        for(int i=0; i<strs.length; i++){
//
//            int[] count=new int[26];
//            for(char ch:strs[i].toCharArray()){
//                count[ch-'a']++;
//
//            }
//
//            StringBuilder keyBuilder=new StringBuilder();
//
//
//            for(int c: count){
//                keyBuilder.append('#').append(c);
//            }
//            String key=keyBuilder.toString();
//
//            m.putIfAbsent(key, new ArrayList<>());
//
//            m.get(key).add(strs[i]);
//
//
//        }
//
//        List<List<String>> res=new ArrayList<>();
//
//        for (Map.Entry<String, List<String>> entry : m.entrySet()) {
//
//            String key = entry.getKey();
//
//            List<String> temp = entry.getValue();
//
//            res.add(temp);
//
//
//
//        }
//
//
//        return res;
//
//
//
//
//    }
//}


//leetcode problem link: https://leetcode.com/problems/group-anagrams/description/
