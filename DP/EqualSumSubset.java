/*
leetcode problem link : https://leetcode.com/problems/partition-equal-subset-sum/description/

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

package DataStructuresAndAlgo.DP;

public class EqualSumSubset {
    class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int equalSum=0;
        int n=nums.length;
        for(int i=0; i<n; i++)
        sum+=nums[i];
         if (sum % 2 != 0) return false;
    equalSum=sum/2;
        boolean[][] dp=new boolean[n+1][equalSum+1];
        for(int i=0; i<=n; i++){
            dp[i][0]=true;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=equalSum; j++){
                if(nums[i-1]<=j)
               
// If I take nums[i-1],can the remaining sum be formed from earlier numbers?..thats y we are subracting the current element from sum i.e., j-nums[i-1]
                dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][equalSum];
    }
}
}
