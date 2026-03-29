package Miscellanious;

import java.util.Random;

public class ShuffleAnArray {
    class Solution {
    int[] originalArray;
    int[] nums;

    public Solution(int[] nums) {

        originalArray=nums.clone();
        this.nums=nums;

        
    }
    
    public int[] reset() {
        return originalArray;
        
    }
    
    public int[] shuffle() {

       Random rand = new Random();

for (int i = nums.length - 1; i > 0; i--) {
    int j = rand.nextInt(i + 1);  
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
