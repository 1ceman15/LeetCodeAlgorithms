
//https://leetcode.com/problems/jump-game-ii/

public class JumpGame2 {
    public int jump(int[] nums) {
        int result = 0;
        int n = nums.length;

        int left = 0;
        int right = 0;

        while (right < n - 1) {
            int further = 0;
            for (int i = left; i <= right; i++) {
                further = Math.max(further, i + nums[i]);
            }
            left = right+1;
            right = further;
            result++;
        }


        return result;

    }
}
