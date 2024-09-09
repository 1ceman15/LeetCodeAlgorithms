//https://leetcode.com/problems/set-matrix-zeroes/description/

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean Corner = false;
        int rows = matrix.length;
        int colm = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colm; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    if(i != 0)
                        matrix[i][0] = 0;
                    else Corner = true;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < colm; i++) {
            if(matrix[0][i] == 0){
                for (int j = 0; j <matrix.length ; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if(Corner){
            Arrays.fill(matrix[0], 0);
        }

    }

}
