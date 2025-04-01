
//https://leetcode.com/problems/summary-ranges/description/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return result;

        int start = nums[0];
        int end = nums[0];


        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (end + 1 == now) {
                end = now;
            } else{
                if(end != start)
                    result.add(start + "->" + end);
                else result.add(start + "");
                start = now;
                end = now;
            }
        }

        if(end != start)
            result.add(start + "->" + end);
        else result.add(start + "");

        return result;
    }
}
