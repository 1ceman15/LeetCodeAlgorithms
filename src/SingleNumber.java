
//https://leetcode.com/problems/single-number/

//Use XOR
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            number = number ^ nums[i];
        }
        return number;
    }
}
