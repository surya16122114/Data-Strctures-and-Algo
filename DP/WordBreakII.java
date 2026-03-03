package DP;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
   class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
          List<String> res = new ArrayList<>();
        solve(s, wordDict, 0, "", res);
        return res;
        
    }

    public void solve(String s, List<String> wordDict, int index, String current, List<String> res){
        if(index==s.length()){
            res.add(current);
            return;
        }

        for(String st: wordDict){
            if(index+st.length()<=s.length() && s.substring(index, index+st.length()).equals(st)){
                String newCurrent=current.isEmpty()?st:current+" "+st;
                

                solve(s, wordDict, index+st.length(), newCurrent, res);
            }
        }
    }
} 
}
