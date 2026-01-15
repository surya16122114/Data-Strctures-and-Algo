/* 
Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i. Your task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: n = size of price, and price[] is 1-indexed array.

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.
Input: price[] = [3]
Output: 3
Explanation: There is only 1 way to pick a piece of length 1.
gfg problem link: https://www.geeksforgeeks.org/problems/rod-cutting0840/1
*/
package DataStructuresAndAlgo.DP;
public class RodCuttingGfg {
   class Solution {
    public int cutRod(int[] price) {
        // code here
        //max length--n
        //length of the value array is also n
        int n=price.length;
        int[][] dp=new int[n+1][n+1];
        int[] weight=new int[n];
        for(int i=0; i<n; i++)
        weight[i]=i+1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(weight[i-1]<=j)
                dp[i][j]=Math.max(price[i-1]+dp[i][j-weight[i-1]],dp[i-1][j]);
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n][n];
        
        //for piece length 1 can we use length 1
        //for piece length 2 can we use length 1...like this
    }
} 
}
