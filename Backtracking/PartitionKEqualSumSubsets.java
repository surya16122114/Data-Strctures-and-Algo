package Backtracking;

public class PartitionKEqualSumSubsets {
   class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
int n= nums.length;
      int sum=0;
        for(int i=0; i<n; i++)
        sum+=nums[i];

        if(sum%k!=0)
        return false;

        int reqSum=sum/k;
        
boolean[] visited=new boolean[n];
          
        return solve(nums, visited, 0, 0, reqSum, k);
       

        
    }
    public boolean solve(int[] nums, boolean[] visited, int index, int currSum , int reqSum, int k){

        if(k==0)
        return true;

        if(currSum==reqSum)
       return solve(nums, visited, 0, 0, reqSum, k-1);

       

        for(int i=index; i<nums.length; i++){
             if(visited[i])
        continue;

        if(nums[i]+currSum>reqSum)
        continue;

        visited[i]=true;

        if(solve(nums, visited, i+1, currSum+nums[i], reqSum, k))
        return true;

        visited[i]=false;
        }

        return false;

      

    }
} 
}
