
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/


import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % k != 0)
            return false;

        target = target / k;

        int[] sums = new int[k];

        Arrays.sort(nums);

        return backtracking(nums, sums, target, nums.length - 1);

    }

    public boolean backtracking(int[] nums, int[] sums, int target, int index) {
        if (index < 0)
            return true;

        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > target) {
                continue;
            }
            sums[i] += nums[index];
            if (backtracking(nums, sums, target, index - 1))
                return true;

            sums[i] -= nums[index];
            if (sums[i] == 0)
                break;
        }

        return false;


    }
}
