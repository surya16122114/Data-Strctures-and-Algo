package DataStructuresAndAlgo.DP;
//leetcode problem link : https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {
    class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0)
                dp[i][j]=1;
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //consider the numebr of ways from the left+top to get the current position
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
}
}


//O(m*n) time and O(m*n) space solution
//The idea is to use dynamic programming to build a 2D array where each cell represents the number of unique paths to that cell from the top-left corner.
//The number of unique paths to each cell is the sum of the number of unique paths to the cell directly above it and the cell directly to the left of it.