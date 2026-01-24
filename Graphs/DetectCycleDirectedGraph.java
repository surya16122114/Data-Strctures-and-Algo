import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean[] visited=new boolean[V];
        boolean[] dfsVisited=new boolean[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        
        for(int i=0; i<V; i++){
            if(!visited[i] && detectCycle(adj, i, visited, dfsVisited)){
                return true;
            }
            
        }
        return false;
        
    }
    
    
    public boolean detectCycle(List<List<Integer>> adj, int start,   boolean[] visited, 
     boolean[] dfsVisited){
         visited[start]=true;
         dfsVisited[start]=true;
         for(int neighbor: adj.get(start)){
             if(!visited[neighbor]){
                 if(detectCycle(adj, neighbor, visited, dfsVisited))
                 return true;
             }
             else if(dfsVisited[neighbor])
             return true;
         }
         
         dfsVisited[start]=false;
         return false;
     }
}
}
