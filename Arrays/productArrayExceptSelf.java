public class productArrayExceptSelf {
    class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum=new int[nums.length];
        int[] sufixSum=new int[nums.length];
        int preSum=1;
        int sufSum=1;
        prefixSum[0]=sufixSum[nums.length-1]=1;
        for(int i=1; i<nums.length; i++){
            preSum=preSum*nums[i-1];
            prefixSum[i]=preSum;
        }
          for(int i=nums.length-2; i>=0; i--){
            sufSum=sufSum*nums[i+1];
            sufixSum[i]=sufSum;
        }
        int[] answer=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            answer[i]=prefixSum[i]*sufixSum[i];
        }
        return answer;
    }
}
}
