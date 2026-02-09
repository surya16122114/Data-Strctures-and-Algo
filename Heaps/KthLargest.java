package Heaps;

import java.util.PriorityQueue;

public class KthLargest {
   class KthLargestElementInAStream {
    int k;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k=k;
        for(int i=0; i<nums.length; i++){
            //we maintain the size k everytime, when the size is >k we will pop the least element, and add the next element

            //we always maintain to three..and the first element in queue is the kth largest

            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        
    }
    
    public int add(int val) {
        //if the size is less than k, we can add the element
        if(pq.size()<k){
            pq.add(val);
        }
        //if the value is also gretaer than the peek, we can add and we have to poll the leats element
        else if(val>pq.peek()){

            pq.add(val);
            pq.poll();
        
        }
          return pq.peek();
    }

  
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */ 
}
