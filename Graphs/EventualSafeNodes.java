import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
List<Integer> ans=new ArrayList<>();
        // code here
        int V=graph.length;
        boolean[] visited=new boolean[V];
        boolean[] dfsVisited=new boolean[V];
        boolean[] check=new boolean[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        
       for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                adj.get(u).add(v);
            }
        }
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
               detectCycle(adj, i, visited, dfsVisited, check);
            }
            
        }
       
       for(int i=0; i<V; i++){
        if(check[i])
        ans.add(i);
       }
        
        return ans;
    }
    
    
    public boolean detectCycle(List<List<Integer>> adj, int start,   boolean[] visited, boolean[] dfsVisited, boolean check[]){
         visited[start]=true;
         dfsVisited[start]=true;
         check[start]=false;
         for(int neighbor: adj.get(start)){
             if(!visited[neighbor]){
                 if(detectCycle(adj, neighbor, visited, dfsVisited, check))
                 return true;
             }
             else if(dfsVisited[neighbor])
             return true;
         }
         
         dfsVisited[start]=false;
         check[start]=true;
         return false;
     }

}

    

}
