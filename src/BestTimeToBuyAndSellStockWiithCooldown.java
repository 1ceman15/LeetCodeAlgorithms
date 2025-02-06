
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/


import java.util.Arrays;

public class BestTimeToBuyAndSellStockWiithCooldown {

    public int maxProfit(int[] prices) {
        final int len = prices.length;
        if (len <= 1) {
            return 0;
        } else if (len == 2) {
            return Integer.max(0, prices[1] - prices[0]);
        }

        // len >= 3
        int[] balance = new int[len], maxProfit = new int[len];
        Arrays.fill(balance, Integer.MIN_VALUE);

        balance[0] = -prices[0];

        balance[1] = Integer.max(balance[0], -prices[1]);
        maxProfit[1] = Integer.max(0, prices[1] - prices[0]);

        for (int i = 2; i < len; ++i) {
            // balance[i-1]: do not purchase on day i
            // maxProfit[i-2] - prices[i]: purchase on day i
            balance[i] = Integer.max(balance[i - 1], maxProfit[i - 2] - prices[i]);

            // maxProfit[i-1]: do not sell on day i
            // balance[i-1] + prices[i]: sell on day i
            maxProfit[i] = Integer.max(maxProfit[i - 1], balance[i - 1] + prices[i]);
        }

        return maxProfit[len - 1];
    }


//    public int maxProfit(int[] prices) {
//        int sold = Integer.MIN_VALUE; //sold → Прибыль, если продали акцию в этот день.
//        int cool = Integer.MIN_VALUE; // cool → Прибыль, если купили акцию в этот день.
//        int reset = 0;//reset → Прибыль, если ничего не делали (ждали).
//
//        for(int i : prices){
//            int prev = sold;
//            sold = cool + i;
//            cool = Math.max(cool, reset - i);
//            reset = Math.max(reset, prev);
//        }
//        return Math.max(sold, reset);
//    }


}
