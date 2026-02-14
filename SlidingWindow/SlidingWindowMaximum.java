package SlidingWindow;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res=new int[nums.length-k+1];
    int index=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

       for(int i=0; i<nums.length; i++){

        pq.offer(new int[]{nums[i], i});

        //if we get the window, window will start from when i=k-1

        if(i>=k-1){
            //we dont have to remove the smaller element even if it is out of window.

            //becoz it cant contribute to answer
            while(pq.peek()[1]<i-k+1){
                pq.poll();
            }

            res[index++]=pq.peek()[0];
        }
       }

       return res;
    }
}
}
