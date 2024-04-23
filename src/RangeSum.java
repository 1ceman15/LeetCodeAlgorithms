
//https://leetcode.com/problems/range-sum-query-immutable/description/

public class RangeSum {
    class NumArray {

        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum+=nums[i];
            }
            return sum;
        }
    }
}
