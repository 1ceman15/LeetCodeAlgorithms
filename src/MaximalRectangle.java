
//https://leetcode.com/problems/maximal-rectangle/description/

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] heights = new int[matrix.length][matrix[0].length];


        for (int i = 0; i < matrix[0].length; i++) {
            heights[0][i] = matrix[0][i] - '0';
        }

        int maxArea = calculateMaxArea(heights[0]);



        for (int i = 1; i < heights.length ; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if(matrix[i][j] == '0')
                    heights[i][j] = 0;
                else {
                    heights[i][j] = heights[i-1][j] + 1;
                }
            }
            maxArea = Math.max(maxArea, calculateMaxArea(heights[i]));

        }

        return maxArea;

    }

    private int calculateMaxArea(int[] matrix){
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > matrix[i]){
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, top[1] * (i - top[0]));
                index = top[0];
            }
            stack.push(new int[]{index, matrix[i]});
        }

        while (!stack.isEmpty()){
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[1] * (matrix.length - top[0]));
        }

        return maxArea;

    }
}
