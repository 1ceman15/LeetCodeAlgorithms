
//https://leetcode.com/problems/jump-game/description/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i] != 0){
                for (int j = i+1; j <= i + nums[i] && j < nums.length; j++) {
                    dp[j]++;
                }
            }

        }



        return dp[nums.length - 1] != 0;

    }
}
