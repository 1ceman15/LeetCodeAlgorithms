
//https://leetcode.com/problems/coin-change/description/

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] numbers = new int[amount+1];
        Arrays.fill(numbers,amount+1);
        numbers[0]  = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin: coins) {
                if(i-coin >= 0){
                    numbers[i] = Math.min(numbers[i], 1 + numbers[i-coin]);
                }
            }
        }

        return numbers[amount] != amount+1? numbers[amount] : -1;

    }


}
