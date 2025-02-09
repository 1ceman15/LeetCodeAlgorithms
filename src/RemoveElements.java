
//https://leetcode.com/problems/remove-element/


public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int place = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                swap(nums, i, place);
                place++;
                continue;
            }
            k++;

        }

        return nums.length-k;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
