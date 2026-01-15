package DataStructuresAndAlgo.DP;

public class LongestIncreasingPathInAMatrix {
    class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];
int ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans=Math.max(ans,dfs(i,j,matrix, dp,-1,m,n));

                //-1 is passed is prev va;lue since all the elements in the matrix are less than zero and we dont return 0, when we are at the first cell
            }
        }

        return ans;
    }

    public int dfs(int r, int c, int[][] matrix, int[][] dp, int prevValue, int m, int n){

//when the indices are out of bounds or the current value is less than or equal to previous value which means the sequence is not increasing
//so return 0;
        if(r<0 || c<0 || r==m || c==n || matrix[r][c]<=prevValue)
        return 0;
//Check the value is already calculated or not from dp
        if(dp[r][c]!=0)
        return dp[r][c];

        int res=0;

//Now call dfs in every direction
        res=Math.max(res, 1+dfs(r, c-1, matrix, dp, matrix[r][c], m,  n));
       res=Math.max(res, 1+dfs(r+1, c, matrix, dp, matrix[r][c],  m, n));
              res=Math.max(res, 1+dfs(r, c+1, matrix, dp, matrix[r][c],  m, n));
                     res=Math.max(res, 1+dfs(r-1, c, matrix, dp, matrix[r][c],  m, n));

                     return dp[r][c]=res;

    }
}
}


//O(m*n) time and O(m*n) space solution
//The idea is to use DFS with memoization to find the longest increasing path starting from each cell in the matrix.
//We maintain a dp array to store the length of the longest increasing path starting from each cell.
//For each cell, we explore all four possible directions (up, down, left, right) and recursively call the dfs function to find the longest increasing path from the neighboring cells.
//We update the dp array with the maximum length found and return it.
//Finally, we iterate through all cells in the matrix and return the maximum length found.  