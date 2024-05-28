
//https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int answer;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        answer =  sum;

        for (int i = k; i < nums.length ; i++) {
            sum -= nums[left];
            sum += nums[i];
            answer = Math.max(answer, sum);
            left++;


        }


        return (double) answer/k;
    }


}
