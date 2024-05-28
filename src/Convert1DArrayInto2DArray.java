
//https://leetcode.com/problems/convert-1d-array-into-2d-array/description/

import java.util.Arrays;

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != n*m)
            return new int[0][0];

        int[][] matrix = new int[m][n];

        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                matrix[i][j] = original[index++];
            }
        }


        return matrix;

    }


    public int[][] construct2DArray2(int[] original, int m, int n) {
        if(original.length != n*m)
            return new int[0][0];

        int[][] matrix = new int[m][n];

        int index = 0;

        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.copyOfRange(original, index, index+n);
            index += n;
        }


        return matrix;

    }

}
