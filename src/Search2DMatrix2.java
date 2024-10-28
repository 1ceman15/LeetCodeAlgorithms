
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int cols = 0;

        while (rows > 0 && cols < matrix[0].length) {
            if (matrix[rows][cols] == target)
                return true;

            if(matrix[rows][cols] > target){
                rows--;
                cols = 0;
            }else cols++;
        }

        return false;

    }
}
