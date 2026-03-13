import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m=heights.length;
        int n=heights[0].length;

        int dist[][]=new int[m][n];
        for(int[] row: dist)
        Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});

        int[] dx={0,0, -1, 1};
        int[] dy={1, -1, 0, 0};
        dist[0][0]=0;

        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int currEffort=temp[0];
            int currRow=temp[1];
            int currCol=temp[2];
                if (currEffort > dist[currRow][currCol]) {
                    continue;
    }
        

            for(int i=0; i<4; i++){
              int nrow=temp[1]+ dx[i];
              int ncol= temp[2]+dy[i];

              if(nrow>=0 && nrow<m  && ncol>=0 && ncol<n){
                int diff=Math.abs(heights[currRow][currCol]-heights[nrow][ncol]);

                int newEffort=Math.max(currEffort, diff);
               if (newEffort < dist[nrow][ncol]) {
                    dist[nrow][ncol] = newEffort;
                    pq.offer(new int[]{newEffort, nrow, ncol});
}
              }
            }

        }
        return dist[m-1][n-1];

        
    }
}
}
