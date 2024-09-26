
//https://leetcode.com/problems/house-robber-ii/description/

public class HouseRobber2 {
    int max;
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int temp = Math.max(rob2, nums[i] + rob1);
            rob1 = rob2;
            rob2 = temp ;
        }
        max = rob2;

        rob1 = 0;
        rob2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(rob2, nums[i] + rob1);
            rob1 = rob2;
            rob2 = temp ;
        }

        max = Math.max(max, rob2);


        return max;
    }
}
