
//https://leetcode.com/problems/longest-increasing-subsequence/description/


import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if(nums[i]<nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

            }

        }

        int max = 0;
        for(int i : dp){
            max = Math.max(max, i);
        }
        System.out.println(Arrays.toString(dp));
        return max;

    }



        public static int lengthOfLIS2(int[] nums) {
            int[] tails = new int[nums.length];
            int size = 0;

            for (int x : nums) {
                int left = 0, right = size;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (tails[mid] < x) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = x;
               if (left == size) {
                    size++;
                }
            }

            return size;
        }


}
