
//https://leetcode.com/problems/daily-temperatures/description/

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] temp = stack.pop();
                answer[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, temperatures[i]});

        }




        return answer;
    }

}
