
//https://leetcode.com/problems/maximum-subarray/submissions/1401906790/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = sum;

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0)
                sum = 0;
            sum+=nums[i];
            result = Math.max(result, sum);
        }

        return result;


    }
}
