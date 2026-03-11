// import java.util.ArrayList;
// import java.util.List;

// public class GraphValidTree {
//     class Solution {
//     public boolean validTree(int n, int[][] edges) {
//             List<List<Integer>> adj=new ArrayList<>();
//         boolean[] visited=new boolean[n];
        
//         for(int i=0; i<n; i++)
//         adj.add(new ArrayList<>());
        
//         for(int[] e : edges){
//            int u= e[0];
//            int v=e[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
        
     
//             if(detectCycleDfs(n, visited, 0, -1,adj))
//             return false;

//             for(int i=0; i<n; i++)
//             {
//                 if(!visited[i])
//                 return false;
//             }
      
        
//         return true;
//     }

//      public boolean detectCycleDfs(int n, boolean[] visited, int src,  
//     int parent, List<List<Integer>> adj){
//         visited[src]=true;
//         for(int neighbor: adj.get(src)){
//             if(!visited[neighbor])
//             {
//                 if(detectCycleDfs(n, visited, neighbor, src,adj))
//                 return true;
//             }
//             else if(parent!=neighbor)
//             return true;
//         }
        
//         return false;
//     }

// }

// }


//approach 2 using dsu
// class Solution {
//             int[] parent;
//     int[] size;
//     public boolean validTree(int n, int[][] edges) {
//         parent=new int[n];
//         size=new int[n];
//         if(edges.length!=n-1)
//         return false;
  
//     for (int i = 0; i < n; i++) { parent[i] = i; size[i] = 1; }


//     for (int[] edge : edges) {
//         int u = edge[0], v = edge[1];
//         if (find(u) == find(v))
//             return false;
//         union( u, v);
//     }

//     return true;
        
//     }




//    public void union(int a, int b) {
//     int ra = find(a), rb = find(b);
//     if (ra == rb) return;

//     if (size[ra] < size[rb]) { parent[ra] = rb; size[rb] += size[ra]; }
//     else                      { parent[rb] = ra; size[ra] += size[rb]; }
// }

// public int find(int x) {
//     if (parent[x] != x)
//         parent[x] = find(parent[x]);
//     return parent[x];
// }



// }