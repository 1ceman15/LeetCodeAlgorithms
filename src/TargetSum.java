
//https://leetcode.com/problems/target-sum/description/

import java.util.Arrays;

public class TargetSum {
    int result = 0;
    int sum;
    int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {

        sum = Arrays.stream(nums).sum();
        memo = new int[nums.length][sum * 2 + 1];

        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }


        backtracking(nums, 0, target, 0);

        return result;
    }


    //Рекурсивное решение c меморизацией
    public void backtracking(int[] nums, int total, int target, int index) {
        if (index == nums.length) {
            if (total == target)
                result++;
            return;
        }
        if (memo[index][total + sum] != Integer.MIN_VALUE) {
            result += memo[index][total + sum];
            return;

        } else {
            int prev = result;
            backtracking(nums, total + nums[index], target, index + 1);
            backtracking(nums, total - nums[index], target, index + 1);
            memo[index][total + sum] = result - prev;

        }

    }


    //Рекурсивное решение за O(2^N)
    public void backtracking(int total, int[] nums, int target, int index) {
        if (index == nums.length) {
            if (total == target)
                result++;
            return;
        }

        backtracking(nums, total + nums[index], target, index + 1);
        backtracking(nums, total - nums[index], target, index + 1);


    }


}
