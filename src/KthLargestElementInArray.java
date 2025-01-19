//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    // O(n logk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num: nums) {
            q.offer(num);
            if(q.size() > k)
                q.poll();
        }

        return q.poll();
    }


    //Average o(n), worst O(n^2)
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        if (p > k) {
            return quickSelect(nums, left, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, right, k);
        } else {
            return nums[p];
        }
    }
}
