import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    class Solution {
    int[] res=new int[2];
    public int[] findRedundantConnection(int[][] edges) {
         List<List<Integer>> adj=new ArrayList<>();
         int V=edges.length;
        
        
        for(int i=0; i<V+1; i++)
        adj.add(new ArrayList<>());
        
        for(int[] e : edges){
           int u= e[0];
           int v=e[1];
           
        boolean[] visited=new boolean[V+1];
           if(hasPathExists(u,v,adj,visited))
           return e;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        
        return new int[0];
    }
    public boolean hasPathExists(int source, int target, List<List<Integer>> adj, boolean[] visited){

        if(source==target)
        return true;
        visited[source]=true;
        for(int neighbor: adj.get(source)){
            if(!visited[neighbor]){
                if(hasPathExists(neighbor,target,adj,visited))
                return true;
            }
           
        }
        
        return false;
    }
}
}


//approach 2 using dsu

// class Solution {
//     int[] parent;
//     int[] size;
//     public int[] findRedundantConnection(int[][] edges) {
//         int n=edges.length;
//         parent=new int[n];
//         size=new int[n];

//         for(int i=0; i<n; i++){
//             parent[i]=i+1;
//             size[i]=i+1;
//         }
//       for(int edge[]: edges){
//    int ra = find(edge[0]), rb = find(edge[1]);
//   if(ra==rb)
//   return new int[]{edge[0], edge[1]};
// else{
//  if (size[ra] < size[rb]) { 
//         parent[ra] = rb; size[rb] += size[ra]; }
//     else                      {
//          parent[rb] = ra; size[ra] += size[rb]; }

//       }
// }

// return new int[]{};
   
 
// }
// public int find(int x) {
//     if (parent[x] != x)
//         parent[x] = find(parent[x]);
//     return parent[x];
// }
        
    
// }