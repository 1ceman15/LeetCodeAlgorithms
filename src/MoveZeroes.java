
//https://leetcode.com/problems/move-zeroes/description/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int helper = nums[index];
                nums[index] = nums[i];
                nums[i] = helper ;
                index++;
            }
        }

    }
}
