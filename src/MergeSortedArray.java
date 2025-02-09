
//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = nums2.length - 1;

        int place = nums1.length -1;

        while (index1 >= 0 && index2 >= 0 ){
            if(nums1[index1] > nums2[index2]){
                nums1[place--] = nums1[index1--];
            }else nums1[place--] = nums2[index2--];
        }
        while (index1 >= 0)
            nums1[place--] = nums1[index1--];

        while (index2 >= 0)
            nums1[place--] = nums2[index2--];

    }

}
