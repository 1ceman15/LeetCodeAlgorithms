
//https://leetcode.com/problems/permutations/description/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        helper(0, nums);
        return result;
    }

    private void helper(int i, int[] nums){
        if(i == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num: nums){
                perm.add(num);
            }
            result.add(perm);
            return;
        }

        for(int idx = i; idx< nums.length; idx++){
            swap(idx,i,nums);
            helper(i+1, nums);
            swap(idx,i,nums);
        }
        return;
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
