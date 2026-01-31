

public class DuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
           
            int n=nums.length;
            for(int i=0; i<n; i++){
               int x = Math.abs(nums[i]);
                if (nums[x - 1] < 0) return x;
                nums[x - 1] = -nums[x - 1];
            }
            return 0;
        }
    }
}
