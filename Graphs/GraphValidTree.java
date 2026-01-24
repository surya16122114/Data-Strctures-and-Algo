import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    class Solution {
    public boolean validTree(int n, int[][] edges) {
            List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];
        
        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());
        
        for(int[] e : edges){
           int u= e[0];
           int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
     
            if(detectCycleDfs(n, visited, 0, -1,adj))
            return false;

            for(int i=0; i<n; i++)
            {
                if(!visited[i])
                return false;
            }
      
        
        return true;
    }

     public boolean detectCycleDfs(int n, boolean[] visited, int src,  
    int parent, List<List<Integer>> adj){
        visited[src]=true;
        for(int neighbor: adj.get(src)){
            if(!visited[neighbor])
            {
                if(detectCycleDfs(n, visited, neighbor, src,adj))
                return true;
            }
            else if(parent!=neighbor)
            return true;
        }
        
        return false;
    }

}

}
