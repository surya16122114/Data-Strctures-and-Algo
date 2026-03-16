import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {
    class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0; i<V; i++)
    adj.add(new ArrayList<>());
    
    for(int[] edge: edges){
        int u=edge[0];
        int v=edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
        int[] colored=new int[V];
        for(int i=0; i<V; i++)
        colored[i]=-1;
        
        for(int i=0; i<V; i++){
            if(colored[i]==-1)
            {
                if(!checkBipartite(adj,i, colored))
                return false;
            }
        }
        
        return true;
    }
    
    
    public boolean checkBipartite(List<List<Integer>> adj, int start, int[] colored){
        Queue<Integer> q=new LinkedList<>();
        colored[start]=0;
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            
            for(int neighbor: adj.get(curr)){
                if(colored[neighbor]==-1){
                    colored[neighbor]=1-colored[curr];
                    q.offer(neighbor);
                }
                
                else if(colored[neighbor]==colored[curr]){
                    return false;
                    
                }
            }
            
            
        }
        
        return true;
    }
}
}


//second solution using DSU
// class Solution {
//     int[] parent;
//     int[] size;

//     int find(int x){
//         if(parent[x]!=x)
//         parent[x]=find(parent[x]);

//         return parent[x];
//     }


//     void union(int a, int b){
//         int ra=find(a);
//         int rb=find(b);

//         if(ra!=rb){
//             if(size[ra]<size[rb]){
//                 parent[ra]=rb;
//                 size[rb]+=size[ra];
//             }
//             else{
//                 parent[rb]=ra;
//                 size[ra]+=size[rb];
//             }
//         }
//     }
//     public boolean isBipartite(int[][] graph) {
//         int n=graph.length;

//         parent=new int[n];
//         size=new int[n];

//         for(int i=0; i<n; i++){
//             parent[i]=i;
//             size[i]=1;
//         }

//         for(int i=0; i<n; i++){
//             int[] neighbors=graph[i];

//             if(neighbors.length==0)
//             continue;
//             int firstNeighbor=neighbors[0];

//             for(int neighbor: neighbors){
//                 if(find(neighbor)==find(i))
//                 return false;


//                 union(neighbor, firstNeighbor);
//             }
//         }

//         return true;
        
//     }
// }