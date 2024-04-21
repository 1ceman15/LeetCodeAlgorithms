import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = (HashSet<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i))
                list.add(i);
        }
        return list;
    }
}
