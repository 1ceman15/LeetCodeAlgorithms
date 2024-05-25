
//https://leetcode.com/problems/majority-element/description/

import java.util.Arrays;

public class MajorityElement {
    //Time complexity O(nlogn)
    //Space complexity 0(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }

    //Time complexity O(n)
    //Space complexity 0(1)
    public int BoyerMooreAlgorithm(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(count > nums.length / 2)
                return res;
            if(nums[i] == res)
                count++;
            else
                count--;

            if(count<0){
                res = nums[i];
                count = 1;
            }

        }

        return res;
    }

}
