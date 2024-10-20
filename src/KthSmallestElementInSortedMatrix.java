
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/


public class KthSmallestElementInSortedMatrix {


    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        int min = matrix[0][0];
        int max = matrix[rows - 1][cols - 1];

        while (min <= max) {
            int mid = min + (max-min)/2;




        }





        return min;
    }

    public int lowerOrEqualKthSmallest(int[][] matrix, int k) {




    }




}
