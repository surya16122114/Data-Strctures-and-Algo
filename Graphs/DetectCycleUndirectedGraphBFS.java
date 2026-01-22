import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {
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
            if(detectCycle(V, visited, i, adj))
            return true;
        }
        
        return false;
        
    }
    
    public boolean detectCycle(int V, boolean[] visited, 
    int start,  List<List<Integer>> adj){
        
        visited[start]=true;
        
        Queue<int[]> q=new ArrayDeque<>();
        //current node, parent node
        q.offer(new int[]{start,-1});
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int parent=curr[1];
            
            for(int neighbor: adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.offer(new int[]{neighbor, node});
                }
                else if(parent!=neighbor)
                return true;
            }
        }
        
        return false;
        
    }
}
}
