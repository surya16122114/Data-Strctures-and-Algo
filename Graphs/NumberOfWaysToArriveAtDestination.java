import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
   class Solution {
    public int countPaths(int n, int[][] roads) {
        long[] dist=new long [n];
        long[] ways=new long [n];
        int MOD=(int) 1e9+7;
      
        Arrays.fill(dist, Long.MAX_VALUE);
          dist[0]=0;
          ways[0]=1;
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0; i<n; i++)
        adj.add(new ArrayList<>());


        for(int[] road: roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
             adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));

        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();

            int currNode=(int)curr[1];
            long currDist=curr[0];

            for(int[] neighbor: adj.get(currNode)){
                if(currDist+neighbor[1]<dist[neighbor[0]]){
                    dist[neighbor[0]]=currDist+neighbor[1];
                    pq.offer(new long[]{currDist+neighbor[1], neighbor[0]});
                    ways[neighbor[0]]=ways[currNode];
                }
                else if(currDist+neighbor[1]==dist[neighbor[0]]){
                    ways[neighbor[0]]=(ways[neighbor[0]]+ways[currNode])%MOD;
                }
            }
        }


        return (int) ways[n-1];

   
        
    }
} 
}
