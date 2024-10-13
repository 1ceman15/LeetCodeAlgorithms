
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/



public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {

        int profit = 0;
        int min = prices[0];

        for (int price : prices) {
            if (price < min) min = price;
            else if (price > min + fee) {
                profit += (price - min - fee);
                min = price - fee;
            }
        }
        return profit;
    }

}
