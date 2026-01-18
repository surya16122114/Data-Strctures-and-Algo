import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int temp=q.poll();
            res.add(temp);
            
            for(int neighbor: adj.get(temp)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor]=true;
                }
                  
            }
        }
        
        return res;
        
    }
}
}
