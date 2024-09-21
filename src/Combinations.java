
//https://leetcode.com/problems/combinations/description/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> combine(int n, int k) {

        backtracking(n,k,new ArrayList<>(),1);
        return result;
    }

    public void backtracking(int n, int k, List<Integer> list, int index){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            backtracking(n,k,list,i+1);
            list.remove(list.size()-1);

        }

    }

}
