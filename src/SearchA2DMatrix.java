
//https://leetcode.com/problems/search-a-2d-matrix/



public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int startRow = 0;
        int endRow = matrix.length - 1;

        int startCol = 0;
    int endCol = matrix[0].length - 1;

        while (startRow <= endRow) {
            int midRow = startRow +  (startRow - endRow) / 2;
            if(matrix[midRow][0] <=  target &&  target <= matrix[midRow][endCol]) {
                startRow = midRow;
                break;
            }
            if(matrix[midRow][endCol] <= target) {
                startRow = midRow+1;
            }else endRow = midRow-1;
        }

        startRow = (startRow + endRow) / 2;

        while(startCol <= endCol) {
            int midCol = startCol + (startCol - endCol) / 2;
            if(matrix[startRow][midCol] == target) {
                return true;
            }
            if(matrix[startRow][midCol] > target) {
                endCol = midCol - 1;
            }
            else startCol = midCol+1;
        }



        return false;
    }
}
