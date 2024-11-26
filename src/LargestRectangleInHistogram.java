
//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int answer = 0;

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                answer = Math.max(answer, top[1] * (i - top[0]));
                index = top[0];
            }
            stack.push(new int[]{index, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            answer = Math.max(answer, top[1] * (heights.length - top[0]));
        }





        return answer;

    }

}
