import java.util.ArrayList;
//Conncted
class DFS{
    class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean[] vis=new boolean[n];
        ArrayList<Integer> res=new ArrayList<>();
        solveDfs(adj, vis, 0, res);
        return res;
    }
    
    
    public void solveDfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int start, ArrayList<Integer> res){
        vis[start]=true;
        res.add(start);
        for(int neighbour: adj.get(start)){
            if(!vis[neighbour])
            solveDfs(adj, vis, neighbour, res);
        }
    }
}
}

//If it is disconncted 
/*
for(int i=0; i<n; i++){
    if(!vis[i])
        solveDfs(adj, vis, i, res);
}
    */
    