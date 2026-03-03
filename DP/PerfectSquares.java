package DP;

public class PerfectSquares {
   class Solution {
    public int numSquares(int n) {
      int sizeOfSquaresArray = (int) Math.sqrt(n);

        int[] squares=new int[sizeOfSquaresArray];
        for(int i=0; i<sizeOfSquaresArray; i++)
        squares[i]=(i+1)*(i+1);


        int[][] dp=new int[squares.length+1][n+1];
        int INF=Integer.MAX_VALUE-1;

        for(int i=1; i<=n; i++)
        dp[0][i]=INF;


        for(int i=1; i<=squares.length; i++){
            for(int j=1; j<=n; j++){
                if(squares[i-1]<=j)
                dp[i][j]=Math.min(1+dp[i][j-squares[i-1]], dp[i-1][j]);
                else
                dp[i][j]=dp[i-1][j];
            }
        }

        return dp[squares.length][n];
        
    }
} 
}
