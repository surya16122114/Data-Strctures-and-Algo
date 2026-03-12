class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n+1];
      
        Arrays.fill(dist, Integer.MAX_VALUE);
          dist[k]=0;
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0; i<=n; i++)
        adj.add(new ArrayList<>());


        for(int[] time: times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();

            int currNode=curr[1];
            int currDist=curr[0];

            for(int[] neighbor: adj.get(currNode)){
                if(currDist+neighbor[1]<dist[neighbor[0]]){
                    dist[neighbor[0]]=currDist+neighbor[1];
                    pq.offer(new int[]{currDist+neighbor[1], neighbor[0]});
                }
            }
        }


        int res=0;

        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }

            res=Math.max(res, dist[i]);
        }

        return res;
        
    }
}