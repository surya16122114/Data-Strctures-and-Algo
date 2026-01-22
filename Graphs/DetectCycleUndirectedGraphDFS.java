import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirectedGraphDFS {
    class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[V];
        
        for(int i=0; i<V; i++)
        adj.add(new ArrayList<>());
        
        for(int[] e : edges){
           int u= e[0];
           int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            if(detectCycleDfs(V, visited, i, -1,adj))
            return true;
        }
        
        return false;
        
    }
    
    public boolean detectCycleDfs(int V, boolean[] visited, int src,  
    int parent, List<List<Integer>> adj){
        visited[src]=true;
        for(int neighbor: adj.get(src)){
            if(!visited[neighbor])
            {
                if(detectCycleDfs(V, visited, neighbor, src,adj))
                return true;
            }
            else if(parent!=neighbor)
            return true;
        }
        
        return false;
    }
}
}



