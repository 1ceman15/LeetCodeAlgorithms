
//https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        backtracking(nums, 0, list);


        return result;
    }


    public void backtracking(int[] nums, int index, List<Integer> list) {

        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        backtracking(nums, index + 1, list);
        list.remove(list.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;

        backtracking(nums, index + 1, list);

    }



}
