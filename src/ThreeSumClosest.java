
//https://leetcode.com/problems/3sum-closest/description/?envType=problem-list-v2&envId=array


import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int number1 = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int number2 = nums[left];
                int number3 = nums[right];
                int sum = number1 + number2 + number3;
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(target - answer) > Math.abs(target - sum)) {
                    answer = sum;
                }
                if(sum - number1 > target - number1) {
                    right--;
                }else left++;
            }
        }

        return answer;
    }
}
