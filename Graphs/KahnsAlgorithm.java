import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        }
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