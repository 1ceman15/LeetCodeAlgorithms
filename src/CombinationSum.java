
//https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtracking(0,target,0,new ArrayList<>(),candidates);

        return result;
    }

    public void backtracking(int total, int target,  int index, List<Integer> list, int[] candidates){
        if(total==target){
            result.add(new ArrayList<>(list));
            return;
        }

        if(total>target || index >= candidates.length)
            return;

        backtracking(total,target,index+1,list,candidates);

        list.add(candidates[index]);
        backtracking(total+candidates[index], target, index, list, candidates);
        list.remove(list.size()-1);


    }

}
