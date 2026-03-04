package DP;

public class EditDistance {
    class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=0; i<=m; i++)
        dp[i][0]=i;


        for(int i=0; i<=n; i++)
        dp[0][i]=i;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }

                else{

                    dp[i][j]=1+getMin(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];

        
    }

    public int getMin(int a, int b, int c){
        return a<b && a<c ? a:(b<c? b: c);
    }
}
}
