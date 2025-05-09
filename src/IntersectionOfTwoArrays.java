//https://leetcode.com/problems/intersection-of-two-arrays/


import java.util.Arrays;
import java.util.HashSet;
import java .util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
//        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
//
//        nums1Set.retainAll(nums2Set);
//
//        return nums1Set.stream().mapToInt(Integer::intValue).toArray();
//
//    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        Set<Integer> intersection = new HashSet<>();

        for (int num: nums2) {
            if(nums1Set.contains(num))
                intersection.add(num);
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();

    }
}
