
//https://leetcode.com/problems/permutations-ii/description/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class Permutations2 {
    List<List<Integer>> result = new ArrayList<>();
    int length;
    public List<List<Integer>> permuteUnique(int[] nums) {

   //     Arrays.sort(nums);

        backtracking(0, nums);


//        length = nums.length;
//
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (Integer x: nums) {
//            if(hm.containsKey(x)){
//                hm.put(x,hm.get(x)+1);
//            }
//            else hm.put(x,1);
//        }
//        backtracking(hm,0, new ArrayList<>());
        return result;
    }



//    через boolean[]
//    Создание массива происходит на каждом уровне рекурсии ля того, чтобы
//    на каждом уровне, мы знали, какие элементы уже меняли местами
    private void backtracking(int i, int[] nums){
        if(i == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num: nums){
                perm.add(num);
            }
            result.add(perm);
            return;
        }
        boolean[] isUsed = new boolean[21];
        for(int idx = i; idx< nums.length; idx++){
            if(isUsed[nums[idx]+10])
                continue;
            isUsed[nums[idx]+10] = true;
            swap(idx,i,nums);
            backtracking(i+1, nums);
            swap(idx,i,nums);

        }
        return;
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //через HashMap - больше затрат памяти и доп. время на заполнение HM, но интуитивно понятно
    public void backtracking(HashMap<Integer, Integer> hm, int index, List<Integer> list){

        if(index>=length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (Integer key: hm.keySet()) {
            if(hm.get(key) > 0){
                list.add(key);
                hm.put(key, hm.get(key)-1);
                backtracking(hm,index+1,list);
                hm.put(key, hm.get(key)+1);
                list.remove(list.size()-1);
            }
        }

    }

}
