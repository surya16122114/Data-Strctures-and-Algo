package DP;

import java.util.Arrays;

public class ValidParanthesisString {
    class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();

//we have indices 0...n not n-1 becuase we need to consider the state when we reach the end of the string..it means when we conisder every char in the string
        int[][] dp=new int[n+1][n+1];

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int count=0;
        int index=0;

        //count is the number of unmatched '('
        //dp[index][count]..tells us till this index whether we can form a valid string with the count

        return solve(s,dp,count, index);
        
    }


    public boolean solve(String s, int[][] dp, int count, int index){
        if(index==s.length()){
            return count==0;
        }

        if(dp[index][count]!=-1)
        return dp[index][count]==1;

        boolean answer=false;

        char ch=s.charAt(index);

        if(ch=='('){
            answer=solve(s,dp,count+1, index+1);
        }

        else if(ch==')'){
            //if the count>0 then only we can form a valid string with this ')'
            if(count>0)
            answer=solve(s,dp,count-1, index+1);
        }
//* three cases
        else{
            answer=solve(s,dp,count+1, index+1);//'('..left brace
            answer=answer||solve(s,dp,count,index+1);//''..empty

            if(count>0)//right brace
            answer=answer||solve(s,dp,count-1,index+1);
        }


        dp[index][count]=answer?1:0;

        return answer;
    }
}
}
