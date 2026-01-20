package DataStructuresAndAlgo.DP;

public class DistinctSubsequences {
    class Solution {

        public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp =new int[m+1][n+1];
    
        //when t is empty..you can generate by not taking any character from s
        for(int i=0; i<=m; i++)
        dp[i][0]=1;
          
    
          for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    //when the current chars are equal, so you have to worry how many the prev prefix substrings are euqla..
                //thats y dp[i-1][j-1] when u want to consider
                //when you dont want to consider, current ways are exactly equal to the prev(since the current s chracter is not considered)
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j];
            }
          }
    
          return dp[m][n];
           
        }
    }
}
