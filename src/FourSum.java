
//https://leetcode.com/problems/4sum/?envType=problem-list-v2&envId=array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++ ){
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;

                int left = j + 1, right = nums.length - 1;
                int number2 = nums[j];

                while (left < right) {
                    int number3 = nums[left];
                    int number4 = nums[right];
                    long sum = number3 + number4 + number2 + nums[i];
                    if (sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], number2, number3, number4)));
                        while (left < right && nums[left] == number3)
                            left++;
                        while (left < right && nums[right] == number4)
                            right--;
                    } else if (sum < target) {
                        left++;
                    } else right--;
                }


            }


        }


        return result;
    }


    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(result);
    }
}
