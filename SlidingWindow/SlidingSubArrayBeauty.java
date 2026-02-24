package SlidingWindow;

public class SlidingSubArrayBeauty {
    class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int[] freq=new int[101];
        int[] res=new int[n-k+1];


        for(int i=0; i<k; i++){
            freq[nums[i]+50]++;
        }

        res[0]=solve(freq,x);

        for(int i=k; i<n; i++){
            freq[nums[i-k]+50]--;

         
            freq[nums[i]+50]++;
               res[i-k+1]=solve(freq, x);
        }

        return res;
    }



    public int solve(int[] freq, int x){
        int count=0;

//just scan negative numbers only
        for(int i=0; i<50; i++){
            count+=freq[i];

            if(count>=x)
            return i-50;
        }

        return 0;
    }
}
}
