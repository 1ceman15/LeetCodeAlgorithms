
//https://leetcode.com/problems/min-stack/

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> stack;
    int topIndex;
    List<Integer> min;

    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
        topIndex = -1;
    }

    public void push(int val) {
        stack.add(val);
        topIndex++;
        if(min.size() == 0 || min.get(min.size()-1) >= val)
            min.add(val);
    }

    public void pop() {
        if(stack.get(stack.size()-1).equals(min.get(min.size()-1)))
            min.remove(min.size()-1);
        stack.remove(stack.size()-1);
        topIndex--;
    }

    public int top() {
        return stack.get(topIndex);
    }

    public int getMin() {
        return min.get(min.size()-1);
    }


}
