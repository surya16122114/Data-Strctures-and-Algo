import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelay {
    class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        boolean visited[]=new boolean[n+1];
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++)
        adj.add(new ArrayList<>());

        for(int[] edge: times){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

        pq.add(new Pair(0,k));
int cost=0;
int seen=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
int node=p.to;
          if(visited[node])
          continue;
            visited[node]=true;
            seen++;
              cost=Math.max(cost,p.weight);

              for(int[] neighbor: adj.get(node)){
                if(!visited[neighbor[0]]){
                    pq.add(new Pair(cost+neighbor[1], neighbor[0]));
                }
              }
        }

     
    return seen==n?cost:-1;


    }
}

class Pair{
    int weight;
    int to;
    Pair(int weight, int to){
        this.weight=weight;
        this.to=to;
    }
}
}
