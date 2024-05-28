
//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if(nums[number-1] > 0){
                nums[number-1] = nums[number-1] * -1;
            }else array.add(number);
        }

        return array;
    }
}
