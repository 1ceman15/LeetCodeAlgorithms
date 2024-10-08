
//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(rob2, nums[i] + rob1);
            rob1 = rob2;
            rob2 = temp ;
        }

        return rob2;
    }
}
