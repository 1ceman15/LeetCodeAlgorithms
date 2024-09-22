
//https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        Arrays.sort(candidates);
        //backtracking(new ArrayList<>(), candidates, target, 0, 0);

        backtracking(candidates, new ArrayList<>(), target, 0, 0);
        return result;
    }


    public void backtracking(int[] candidates, List<Integer> list, int target, int total, int index) {
        if (target == total) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (total > target || index >= candidates.length)
            return;

        list.add(candidates[index]);
        backtracking(candidates, list, target, total + candidates[index], index + 1);
        list.remove(list.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1])
            index++;
        backtracking(candidates, list, target, total, index + 1);


    }

    public void backtracking(List<Integer> list, int[] candidates, int target, int total, int index) {
        if (target == total) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (total > target)
            return;

        int prev = -1000;
        for (int i = index; i < candidates.length; i++) {
            if (prev == candidates[i])
                continue;
            prev = candidates[i];
            list.add(candidates[i]);
            backtracking(list, candidates, target, total + candidates[i], i + 1);
            list.remove(list.size() - 1);

        }

    }


}
