//https://leetcode.com/problems/rotate-image/description/


public class RotateImage {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;

                int leftCorner = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i][left];

                matrix[bottom - i][left] = matrix[bottom][right - i];

                matrix[bottom][right - i] = matrix[top+i][right];

                matrix[top+i][right] = leftCorner;
            }
            left++;
            right--;
        }


    }

}

