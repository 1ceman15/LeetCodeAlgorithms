
//https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/?envType=daily-question&envId=2025-02-03
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int inc = 1;
        int dec = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                inc++;
                dec = 1;
            }
            else if(nums[i] < nums[i-1]) {
                dec++;
                inc = 1;
            }
            else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(inc, dec));

        }

        return result;

    }
}
