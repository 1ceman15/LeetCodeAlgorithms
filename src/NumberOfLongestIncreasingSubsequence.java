
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/


import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);

        int maxLength = 0;
        int res = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int len = 1;
            int cnt = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    if (1 + dp[j] > len) {
                        len = 1 + dp[j];
                        cnt = count[j];
                    } else if (1 + dp[j] == len) {
                        cnt += count[j];
                    }

                }
            }
            count[i] = cnt;
            if (len > maxLength) {
                maxLength = len;
                res = cnt;
            } else if (len == maxLength) {
                res += cnt;
            }

        }


        return res;
    }
}
