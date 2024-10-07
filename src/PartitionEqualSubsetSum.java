
//https://leetcode.com/problems/partition-equal-subset-sum/description/

import java.util.HashSet;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        int target = 0;

        for (int num : nums) {
            target += num;
        }

        if (target % 2 == 1)
            return false;

        target = target / 2;


        for (int num : nums) {
            HashSet<Integer> set2 = new HashSet(set);
            for (Integer num1 : set2) {
                if (num1 + num == target) {
                    return true;
                }
                set.add(num1 + num);
            }


        }


        return false;
    }


}
