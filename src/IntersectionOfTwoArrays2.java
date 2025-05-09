//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/


import java.util.*;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> nums1Freq = new HashMap<>();
        Map<Integer, Integer> nums2Freq = new HashMap<>();

        for(int num: nums1){
            nums1Freq.put(num ,nums1Freq.getOrDefault(num,0) + 1);
        }

        for(int num: nums2){
            nums2Freq.put(num ,nums2Freq.getOrDefault(num,0) + 1);
        }

        for(int num: nums1Freq.keySet()) {
            if(nums1Freq.containsKey(num) && nums2Freq.containsKey(num)){
                for (int i = 0; i < Math.min(nums1Freq.get(num), nums2Freq.get(num)); i++) {
                    intersection.add(num);
                }
            }
        }

        return  intersection.stream().mapToInt(Integer::intValue).toArray();
    }



//    public int[] intersect(int[] nums1, int[] nums2) {
//        int l1 = nums1.length;
//        int l2 = nums2.length;
//        int i = 0, j = 0, k = 0;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        while( i < l1 && j < l2)
//        {
//            if(nums1[i] < nums2[j])
//            {
//                i++;
//            }
//            else if(nums1[i] > nums2[j])
//            {
//                j++;
//            }
//            else
//            {
//                nums1[k++] = nums1[i++];
//                j++;
//            }
//        }
//        return Arrays.copyOfRange(nums1,0,k);
//    }
}
