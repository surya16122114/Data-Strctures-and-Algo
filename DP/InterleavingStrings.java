package DP;

public class InterleavingStrings {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if((s1.length()+s2.length())!=s3.length())
            return false;
    
            Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];
            int i=0;
            int j=0;
            int k=0;
    
            return checkInterleave(s1, s2, s3, i,j,k,dp);
            
        }
    
    
        public boolean checkInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp){
            if(k==s3.length()){
                return i==s1.length() && j==s2.length();
            }
    
            if(dp[i][j]!=null)
            return dp[i][j];
    
            boolean ans=false;
    
            if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
                ans=checkInterleave(s1,s2,s3,i+1,j,k+1,dp);
            }
    
            if(!ans && j<s2.length() && s2.charAt(j)==s3.charAt(k)){
                ans=checkInterleave(s1,s2,s3,i,j+1, k+1, dp);
            }
    
            dp[i][j]=ans;
            return ans;
        }
    }
}
