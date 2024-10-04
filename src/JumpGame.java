
//https://leetcode.com/problems/jump-game/description/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int pointer = nums.length - 1;

        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i] + i >= pointer)
                pointer = i;
        }



        return pointer == 0;

    }
}
