/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

leetcode problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

package DataStructuresAndAlgo;

public class StocksBuyAndSell {
 
    public int maxProfit(int[] prices) {
        int profit=0;
        int n=prices.length;
        int minimumPrice=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){

            //Always conisder minimum price to buy
            minimumPrice=Math.min(minimumPrice, prices[i]);
            //but the profit we get may not be from the minimum price we have in the whole array
          //  [7,3,2,9,1,6] in this array the mimimu price is 1 but we cant conisder the profit that is associated with that min price since if we sell for 6, 6-1=5 but we already the profit of 9-2=7
            profit=Math.max(profit, prices[i]-minimumPrice);

        }
        return profit;
    

}
}
