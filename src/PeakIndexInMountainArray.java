
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/


public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if(arr[mid] > arr[mid + 1]) {
                right = mid;
            }else left = mid+1;

        }






        return left;
    }


    public static void main(String[] args) {
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        System.out.println(p.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
