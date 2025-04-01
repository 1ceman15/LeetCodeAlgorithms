
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/


public class LongestSubarrayOf1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int result = 0;

        int  left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            if(nums[right] == 0) {
                count++;
            }
            if(count > 1){
                while(left <nums.length && count > 1){
                    if(nums[left] == 0){
                        count--;
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left);
            right++;
        }



        return result;
    }


}
