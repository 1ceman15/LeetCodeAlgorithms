
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/submissions/1436072464/


public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else left = mid + 1;

            } else if (nums[left] > nums[mid]) {
                if (target <= nums[right] && target > nums[mid])
                    left = mid + 1;
                else right = mid - 1;
            } else{
                left++;
            }

        }


        return false;


    }

}
