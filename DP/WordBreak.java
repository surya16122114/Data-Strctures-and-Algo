package DataStructuresAndAlgo.DP;

import java.util.List;

public class WordBreak {
    class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        //we reached the end
        dp[n]=true;
        for(int i=n-1; i>=0; i--){
            for(String st: wordDict){
                if(i+st.length()<=n && s.substring(i, i+st.length()).equals(st) ){
                    dp[i]=dp[i]||dp[i+st.length()];
                }
                if(dp[i])
                break;
            }
        }

        return dp[0];
    }
}
}
