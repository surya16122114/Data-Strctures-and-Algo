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
