
//https://leetcode.com/problems/subsets/description/


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> list = new ArrayList<>();

        DFS(nums, 0, list);


        return result;
    }

    public void DFS(int[] nums, int index, List<Integer> list) {


        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        DFS(nums, index + 1, list);
        list.add(nums[index]);
        DFS(nums, index + 1, list);
        list.remove(list.size() - 1);

    }
}
