
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/


public class KthSmallestElementInSortedMatrix {
    int rows;
    int cols;


    public int kthSmallest(int[][] matrix, int k) {
        rows = matrix.length - 1;
        cols = matrix[0].length - 1;

        int min = matrix[0][0];
        int max = matrix[rows][cols];

        while (min <= max) {
            int mid = (max - min) / 2;
            if (lowerOrEqualKthSmallest(matrix, mid) >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }


        return min;
    }

    public int lowerOrEqualKthSmallest(int[][] matrix, int k) {
        int count = 0;

        int j = cols;


        for (int i = 0; i <= rows; i++) {
            while (j >= 0) {
                if (matrix[i][j] > k) {
                    j--;
                } else {
                    break;
                }

            }
            count += j + 1;
            j = cols;
        }


        return count;

    }

}
