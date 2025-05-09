//https://leetcode.com/problems/implement-queue-using-stacks/


import java.util.Stack;

public class MyQueue {

    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;

    public MyQueue() {
        this.mainStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void push(int x) {
        helperStack.push(x);
    }

    public int pop() {
        if(mainStack.isEmpty())
            restore();
        return mainStack.pop();
    }

    public int peek() {
        if(mainStack.isEmpty())
            restore();
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty() && helperStack.isEmpty();
    }

    public void restore() {
        while (!helperStack.isEmpty()){
            mainStack.push(helperStack.pop());
        }
    }

}
