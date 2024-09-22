
//https://leetcode.com/problems/combination-sum-iii/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        backtracking(new ArrayList<>(),k,n,0,1);
        return result;
    }
    public void backtracking(List<Integer> list, int length, int target, int total, int index){
        if(target==total && list.size() == length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < 10; i++) {
            list.add(i);
            backtracking(list,length,target,total+i,i+1);
            list.remove(list.size()-1);
        }

    }
}
