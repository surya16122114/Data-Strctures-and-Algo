import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1)
        return nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);

        for(int i=0; i<nums.length; i++){
            pq.offer(nums[i]);
        }
        int startElement=pq.poll();

        int count=1;
        int res=1;
        while(!pq.isEmpty()){
            int curr=pq.poll();
            if(Math.abs(curr-startElement)==0)
            continue;

            else if(Math.abs(curr-startElement)==1){
                count++;
                startElement=curr;
            }
            else{
                count=1;
                startElement=curr;
            }

            res=Math.max(res, count);
        }

        return res;
        
    }
}
}
