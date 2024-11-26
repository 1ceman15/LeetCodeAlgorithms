
//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int first;
        int second;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }


        return stack.pop();
    }
}
