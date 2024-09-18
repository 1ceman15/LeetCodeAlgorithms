
//https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toSet()));

        for (int i : set) {
            if(!set.contains(i-1)){
                int length = 1;
                while (set.contains(i + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }


}
