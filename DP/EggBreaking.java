package DataStructuresAndAlgo.DP;

import java.util.Arrays;

public class EggBreaking {
    class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp=new int[k+1][n+1];
        for (int i = 0; i <= k; i++) {
    Arrays.fill(dp[i], -1);
}
        return solve(k,n,dp);
    }

    public int solve(int eggs, int floors,  int[][] dp){
        if(eggs==1)
        return floors;
        if(floors==0 || floors==1)
        return floors;


        if(dp[eggs][floors]!=-1)
        return dp[eggs][floors];

        int minAttempts=Integer.MAX_VALUE;
        int low=1;
        int high=floors;
        while(low<=high){
            int mid=low+(high-low)/2;
            //if the egg breaks, try the floors(k-1) which are below the current floor, since if we try above the egg will break
            //since the egg was broken, now we have eggs-1 eggs.
            int doesBreak=solve(eggs-1, mid-1, dp);
//if the egg doesnot break, we have to try from the one above the current floor.
//since the egg was not broken, we can use the same egg.
            int doesnotBreak=solve(eggs, floors-mid, dp);
            //worst case ..we dont know which case we will get that's y we are considering the worts case
            //which is btw max;
            int worstCase=1+Math.max(doesBreak, doesnotBreak);
            minAttempts=Math.min(minAttempts, worstCase);
            
            if(doesBreak>doesnotBreak){
                high=mid-1;

            }
            else
            low=mid+1;
        }

        dp[eggs][floors]=minAttempts;

        return minAttempts;


    }
}
}
