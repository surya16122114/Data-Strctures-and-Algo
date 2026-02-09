package Heaps;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int m=points.length;

        for(int i=0; i<m; i++){
           
            int[] coordinates=points[i];
            int distance=(coordinates[0]*coordinates[0])+(coordinates[1]*coordinates[1]);
            pq.offer(new int[]{distance, coordinates[0], coordinates[1]});
             if(pq.size()>k)
                pq.poll();

        }

        int[][] ans=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
                int[] top=pq.poll();
                ans[i]=new int[]{top[1], top[2]};
                i++;

        }

        return ans;
        
    }
}
}
