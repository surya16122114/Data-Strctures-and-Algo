package Greedy;

public class JumpGame {
    class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable=nums[0];

        for(int i=1; i<nums.length; i++){
            //u r not able to reach this position
            if(i>maxReachable)
            return false;

            maxReachable=Math.max(maxReachable, i+nums[i]);
        }

        if(maxReachable>=nums.length-1)
        return true;
        else
        return false;
    }

    //differet approach from the end
    // public boolean canJump(int[] nums) {
    //     int goal=nums.length-1;
    //     for(int i=nums.length-2; i>=0; i--){
    //         if(i+nums[i]>=goal)
    //         goal=i;
    //     }
    //     return goal==0?true:false;
    // }
}
}
