package DataStructuresAndAlgo;

public class DecodeWays {
    class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        for(int i=0; i<s.length(); i++)
        dp[i]=-1;
        return solve(0, s, dp);
    }

    public int solve(int idx, String s, int[] dp){
        if(idx==s.length())
        return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1)
        return dp[idx];

        int res=solve(idx+1, s, dp);
        if(idx<s.length()-1){
            if(s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<'7'))
            res=res+solve(idx+2, s, dp);
        }
        dp[idx]=res;
        return res;
    }
}
}
