import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/contains-duplicate/
public class Duplicates {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = (HashSet<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if(set.size() < nums.length)
            return true;
        else return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            else set.add(nums[i]);
        }

         return false;
    }
}
