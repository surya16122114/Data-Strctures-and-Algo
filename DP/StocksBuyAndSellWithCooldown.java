package DP;

import java.util.Arrays;

public class StocksBuyAndSellWithCooldown {
    class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int[][] dp=new int[n][2];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int index=0;

        return solve(prices, 1, dp, index);
        
    }


    public int solve(int[] prices, int buying, int[][] dp, int index){


        if(index>=prices.length)
        return 0;

        if(dp[index][buying]!=-1)
        return dp[index][buying];


        int cooldown=solve(prices, buying, dp, index+1);

        if(buying==1){
            int buy=solve(prices, 0, dp, index+1)-prices[index];
            dp[index][buying]=Math.max(cooldown, buy);
        }

        else{
            int sell=solve(prices, 1, dp, index+2)+prices[index];
            dp[index][buying]=Math.max(cooldown, sell);
        }


        return dp[index][buying];
    }
}
}
//leetcode problem link