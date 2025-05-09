import java.util.Stack;

public class MaxStack {
//    Stack<Integer> stack;
//    Stack<Integer> maxStack;
//
//    public MaxStack(){
//        this.maxStack = new Stack<>();
//        this.stack = new Stack<>();
//    }
//
//    public void push(int val){
//        stack.push(val);
//        if(maxStack.isEmpty())
//            maxStack.push(val);
//        else maxStack.push(Math.max(maxStack.peek(), val));
//    }
//
//
//    public int pop(){
//        maxStack.pop();
//        return stack.pop();
//    }
//
//    public int top(){
//        return stack.peek();
//    }
//
//    public int peekMax(){
//        return maxStack.peek();
//    }
//
//
//    public int popMax(){
//        int max = peekMax();
//        Stack<Integer> buffer = new Stack<>();
//        while (top() != max){
//            buffer.push(pop());
//        }
//
//        pop();
//
//        while (!buffer.isEmpty()){
//            push(buffer.pop());
//        }
//
//
//        return max;
//    }

    class Node {
        public int val;
        public Node prev, next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }



}
