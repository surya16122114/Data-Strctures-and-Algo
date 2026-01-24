import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    class Solution {
    public int countComponents(int n, int[][] edges) {
                  List<List<Integer>> adj=new ArrayList<>();
        boolean[] vis=new boolean[n];
        int res=0;
        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());
        
        for(int[] e : edges){
           int u= e[0];
           int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
       
        for(int i=0; i<n; i++){
            if(!vis[i]){
                solveDfs(adj, vis, i);
                res++;
            }
        }
        
        return res;
    }
        
    public void solveDfs(List<List<Integer>> adj, boolean[] vis, int start){
        vis[start]=true;
      
        for(int neighbour: adj.get(start)){
            if(!vis[neighbour])
            solveDfs(adj, vis, neighbour);
        }
    }

}

}
