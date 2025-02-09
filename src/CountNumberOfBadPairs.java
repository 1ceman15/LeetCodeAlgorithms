
//https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-02-09

import java.util.HashMap;

public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        HashMap<Long, Long> hm = new HashMap<>();
        int n = nums.length;
        long result = (long) n * (n - 1) / 2;

        for (int i = 0; i < nums.length; i++) {
            long diff = nums[i] - i;
            result -= hm.getOrDefault(diff, 0l);
            hm.put(diff, hm.getOrDefault(diff, 0l) + 1);
        }

        return result;

    }
}
