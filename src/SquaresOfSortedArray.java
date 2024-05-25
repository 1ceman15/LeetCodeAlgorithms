
//https://leetcode.com/problems/squares-of-a-sorted-array/description/

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int index = right;

        int[] answer = new int[nums.length];

        while (left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                answer[index--] = nums[left] * nums[left];
                left++;
            }
            else{
                answer[index--] = nums[right] * nums[right];
                right--;
            }

        }
        return answer;

    }

}
