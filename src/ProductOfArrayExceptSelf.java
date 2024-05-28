
//https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int helper = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = helper;
            helper *= nums[i];
        }

        helper = 1;

        for (int i = nums.length-1; i >= 0; i--) {
            answer[i] = answer[i] * helper;
            helper *= nums[i];
        }

        return answer;
    }
}
