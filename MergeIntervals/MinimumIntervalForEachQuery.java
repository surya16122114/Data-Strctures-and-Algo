package MergeIntervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MinimumIntervalForEachQuery{
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
    
            Map<Integer, Integer> m=new HashMap<>();
    
            Arrays.sort(intervals, (a,b)->a[0]-b[0]);
       
            int j=0;
          for( int i : Arrays.stream(queries).sorted().toArray()){
                while(j<intervals.length && intervals[j][0]<=i){
                    pq.offer(new int[]{intervals[j][1]-intervals[j][0]+1,intervals[j][1] });
                    j++;
                }
    
    
                while(!pq.isEmpty() && pq.peek()[1]<i){
                    pq.poll();
                }
    
                m.put(i, pq.isEmpty()?-1:pq.peek()[0]);
            }
    
            int[] ans=new int[queries.length];
            for(int i=0; i<queries.length; i++){
                ans[i]=m.get(queries[i]);
            }
    
           return  ans;
        }
    }
}
