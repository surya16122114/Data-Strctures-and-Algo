package MergeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n=intervals.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int i=0; i<n; i++){
            if(!pq.isEmpty() && pq.peek()[1]<=intervals[i][0])
            pq.poll();

            pq.offer(new int[]{intervals[i][0], intervals[i][1]});
        }

        return pq.size();
    }
}
}
