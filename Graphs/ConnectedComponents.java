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


//approach 2 using dsu
// class Solution {
//            int[] parent;
//     int[] size;   
//     public int countComponents(int n, int[][] edges) {
//   parent= new int[n];
//   size= new int[n];
//     for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }

//     int components = n; 

//     for (int[] edge : edges) {
//         int ra = find(edge[0]);
//         int rb = find(edge[1]);
//         if (ra != rb) {
//             if (size[ra] < size[rb]) { parent[ra] = rb; size[rb] += size[ra]; }
//     else                      { parent[rb] = ra; size[ra] += size[rb]; }
//        components--;
//         }
     
//     }
//     return components;
//     }



// public int find(int x) {
//     if (parent[x] != x)
//         parent[x] = find(parent[x]);
//     return parent[x];
// }
// }

//leetcode problem link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/