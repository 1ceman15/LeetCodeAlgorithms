
//https://leetcode.com/problems/3sum/description/?envType=problem-list-v2&envId=array


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length) {
            int number1 = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int number2 = nums[left];
                int number3 = nums[right];
                if (number2 + number3 == -number1) {
                    result.add(Arrays.asList(number1, number2, number3));
                    while (left < right && nums[left] == number2)
                        left++;
                    while (left < right && nums[right] == number3)
                        right--;
                } else if (nums[left] + nums[right] > -number1) {
                    right--;
                } else left++;

            }
            while (i < nums.length && nums[i] == number1) {
                i++;
            }


        }

        return result;
    }

}
