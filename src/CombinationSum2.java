
//https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);


        backtracking(candidates, new ArrayList<>(), target, 0, 0);
        return result;
    }
    public void backtracking(int[] candidates, List<Integer> list, int target, int total, int index){
        if(target==total){
            result.add(new ArrayList<>(list));
            return;
        }

        if(index>=candidates.length || total > target)
            return;

        list.add(candidates[index]);
        backtracking(candidates,list,target,total+candidates[index], index+1);
        list.remove(list.size()-1);

        while (index+1<candidates.length && candidates[index] == candidates[index+1])
            index++;
        backtracking(candidates, list, target, total, index+1);


    }


    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(c.result);
    }

}
