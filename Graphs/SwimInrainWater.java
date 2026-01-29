import java.util.PriorityQueue;

public class SwimInrainWater {
    class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);


        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        pq.offer(new int[]{grid[0][0], 0, 0});

        visited[0][0]=true;
          int[] dx={0,0,1,-1};
          int[] dy={1,-1,0,0};


        while(!pq.isEmpty()){
           int[] curr= pq.poll();
           int time=curr[0];
           int row=curr[1];
           int col=curr[2];
           if(row==n-1 && col==n-1)
           return time;
            for(int i=0; i<4; i++){
                 if(row+dx[i]<0 || col+dy[i]<0 || row+dx[i]>=n || col+dy[i]>=n || visited[row+dx[i]][col+dy[i]])
           continue;

           visited[row+dx[i]][col+dy[i]]=true;
           pq.offer(new int[]{Math.max(time, grid[row+dx[i]][col+dy[i]]), row+dx[i], col+dy[i]});
            }
          




        }

        return Integer.MIN_VALUE;
    }
}
}
