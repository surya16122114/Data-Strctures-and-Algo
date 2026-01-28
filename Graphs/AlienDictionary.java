import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    class Solution {
    public String findOrder(String[] words) {
        // code here
       
        
        Set<Character> set=new HashSet<>();
        for(String s:words){
            for(char ch: s.toCharArray())
            set.add(ch);
        }
        int graphSize=set.size();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<graphSize; i++){
            adj.add(new ArrayList<>());
        }
        ArrayList<Character> idxToChar=new ArrayList<>(set);
        //map the letters to the indices..this is to make usre that graoh indices does not go out of bounds
        Map<Character, Integer> charToIdx=new HashMap<>();
        for(int i=0; i<idxToChar.size(); i++){
            charToIdx.put(idxToChar.get(i), i);
        }
        
        for(int i=0; i<words.length-1; i++){
            String s1=words[i];
            String s2=words[i+1];
           //we need to iterate till the length of the minimum string 
            int lenOfMinimumString=Math.min(s1.length(), s2.length());
            boolean foundDiff=false;
            for(int j=0; j<lenOfMinimumString; j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int u=charToIdx.get(s1.charAt(j));
                    int v=charToIdx.get(s2.charAt(j));
                    adj.get(u).add(v);
                    foundDiff=true;
                    break;
                }
                 //if no difference found ...lets say abc and ab..this case is wrong we have to return empty
                 
            }
            if(s1.length()>s2.length() && !foundDiff)
                 return "";
           
            
           
        }
        
        ArrayList<Integer> tempAns=topoSort(graphSize,adj);
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<tempAns.size(); i++){
            sb.append(idxToChar.get(tempAns.get(i)));
        }
        String ans=sb.toString();
        return tempAns.size()<graphSize?"":ans;
        
   
        
    }
        public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
     
        int[] indegree=new int[V];
        
        for(int i=0; i<V; i++){
            for(int neighbor:adj.get(i))
            indegree[neighbor]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0)
            q.offer(i);
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int currNode=q.poll();
            res.add(currNode);
            for(int neighbor: adj.get(currNode)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)
                q.offer(neighbor);
            }
        }
        

        return res;
    }
}
}
