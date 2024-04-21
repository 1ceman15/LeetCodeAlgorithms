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
}
