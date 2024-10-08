
//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {

    //Floyd's algorithm
    public  static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow!=fast);
        slow = nums[0];

        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;


    }
}
