
//https://leetcode.com/problems/partition-equal-subset-sum/description/

import java.util.HashSet;

public class PartitionEqualSubsetSum {

    Boolean[][] dp;
    public boolean canPartition(int[] nums) {

        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if(target % 2 != 0) return false;

        target /= 2;


        dp = new Boolean[nums.length][target];


        return backtracking(nums,target,0,0);
    }

    boolean partition(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        int target = 0;

        for (int num : nums) {
            target += num;
        }

        if (target % 2 == 1)
            return false;

        target = target / 2;


        for (int num : nums) {
            HashSet<Integer> set2 = new HashSet(set);
            for (Integer num1 : set2) {
                if (num1 + num == target) {
                    return true;
                }
                set.add(num1 + num);
            }


        }


        return false;
    }


    public boolean backtracking(int[] nums, int target, int sum, int index) {
        if(sum == target) {
            return true;
        }
        if(sum > target || index >= nums.length) {
            return false;
        }
        if(dp[index][sum] != null) {
            return dp[index][sum];
        }

        dp[index][sum] = backtracking(nums, target, sum + nums[index], index + 1)
                || backtracking(nums, target, sum, index + 1);

        return dp[index][sum];

    }


}
