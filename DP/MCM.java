package DataStructuresAndAlgo.DP;

import java.util.Arrays;

public class MCM {
    class Solution {
        static int matrixMultiplication(int arr[]) {
            // code here
            int n=arr.length;
            int[][] dp=new int[n+1][n+1];
             for (int[] row : dp) Arrays.fill(row, -1);
             return solve(arr, 1,n-1, dp);
            
        }
        
        static int solve(int arr[], int i, int j, int[][] dp){
            if(i>=j)
            return 0;
            if(dp[i][j]!=-1)
            return dp[i][j];
            int ans=Integer.MAX_VALUE;
            
            for(int k=i; k<j; k++){
                int temp=solve(arr, i, k, dp)+solve(arr, k+1, j, dp)+arr[i-1]*arr[k]*arr[j];//the last guy is the cost when multiply AB and CD
                //the first two solves are AB and CD.
                ans=Math.min(temp, ans);
            }
            dp[i][j]=ans;
           return ans;
        }
    }
}


//This is really hard to think of