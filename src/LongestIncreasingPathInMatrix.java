
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    int rows;
    int cols;
    int[][] dp;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int result = 1;
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result, dfs(matrix, i, j));
            }
        }


        return result;

    }

    public int dfs(int[][] matrix, int x, int y) {
        if (x >= rows || y >= cols || x < 0 || y < 0)
            return 0;

        if (dp[x][y] != -1)
            return dp[x][y];

        int max = 0;


        for (int[] dir : directions) {
            int i = x + dir[0];
            int j = y + dir[1];

            if (i >= rows || j >= cols || i < 0 || j < 0 || matrix[i][j] <= matrix[x][y])
                continue;

            max = Math.max(max, dfs(matrix, i, j));


        }

        return dp[x][y] = 1 + max;

    }
}
