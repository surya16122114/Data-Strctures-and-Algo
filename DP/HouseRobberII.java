//leetcoode problem link: https://leetcode.com/problems/house-robber-ii/description/
package DataStructuresAndAlgo.DP;

public class HouseRobberII {
  class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
 
         if(n==1)
         return nums[0];
       int prev1=0;
       int prev2=0;
       int curr1=0;
       int curr2=0;
         for(int i=0; i<n-1; i++){
            curr1=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr1;
         }

         prev1=0;
         prev2=0;
           for(int i=1; i<n; i++){
            curr2=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr2;
         }
         return Math.max(curr1,curr2);
        
    }
} 
}


//O(n) time and O(1) space solution
//The idea is to run the house robber 1 algorithm twice, once excluding the first house and once excluding the last house.
//Then take the maximum of the two results.