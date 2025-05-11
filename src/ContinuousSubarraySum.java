
//https://leetcode.com/problems/continuous-subarray-sum/

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if(remainderIndex.containsKey(remainder)){
                if((i - remainderIndex.get(remainder)) > 1)
                    return true;
            }
            else remainderIndex.put(remainder,i);

        }

        return false;
    }
}
