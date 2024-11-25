
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=array

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int valid = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i != nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[valid++] = nums[i];
        }

        return valid;
    }

}
