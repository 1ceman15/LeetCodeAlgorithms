
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/



public class BestTimeToBuyAndSellStock2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];


        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
            if(buy > prices[i]) {
                buy = prices[i];
            }
        }



        return profit;
    }
}


