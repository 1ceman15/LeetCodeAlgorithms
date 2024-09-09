//https://leetcode.com/problems/spiral-matrix/description/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;

        while (left < right && top < bottom) {

            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right - 1]);
            }
            right--;

            if (left >= right || top >= bottom)
                break;

            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom - 1][i]);
            }

            bottom--;

            for (int i = bottom - 1; i > top - 1; i--) {
                result.add(matrix[i][left]);
            }
            left++;


        }


        return result;
    }


}
