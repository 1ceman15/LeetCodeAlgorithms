
//https://leetcode.com/problems/coin-change-ii/
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

         for(int coin: coins){
             for (int i = 0; i <= amount; i++) {
                 if(coin<=i)
                     dp[i] += dp[i-coin];
             }
         }


        return dp[amount];
    }
}
