import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCostConnectingAllPoints {
    class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Edge>> adj=new ArrayList<>();
        

        int n=points.length;    
        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int x1=points[i][0];
            int y1=points[i][1];

            for(int j=i+1; j<n; j++){
                int x2=points[j][0];
                int y2=points[j][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                adj.get(i).add(new Edge(j,dist));
                adj.get(j).add(new Edge(i, dist));

            }
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

        boolean[] visited=new boolean[n];

        pq.add(new Pair(0,0));
        int cost=0;

        while(!pq.isEmpty()){
                Pair p=pq.poll();
              
                int node=p.node;
                if(visited[node])
                continue;
                visited[node]=true;
                  cost+=p.weight;
                for(Edge neighbor: adj.get(node)){
                    if(!visited[neighbor.to]){
                        
                        pq.add(new Pair(neighbor.w, neighbor.to));
                    }
                }
        }

        return cost;
    }
}
class Edge{
    int to;

    int w;
    Edge(int to, int w){
        this.to=to;
        this.w=w;
    }
}

class Pair{
    int weight;
    int node;
    Pair(int weight, int node){
        this.weight=weight;
        this.node=node;
    }
}
}
