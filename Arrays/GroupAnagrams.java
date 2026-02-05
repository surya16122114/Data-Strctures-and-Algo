public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];
        List<List<String>> res = new ArrayList<>();
    
        for(int i = 0; i < n; i++) {  
            if(visited[i])
                continue;
            
            List<String> li = new ArrayList<>();
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
