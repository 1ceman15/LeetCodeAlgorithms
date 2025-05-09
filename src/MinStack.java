
//https://leetcode.com/problems/min-stack/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty())
            minStack.push(val);
        else minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}


class MaxStack2 {
    private class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    private Node head, tail;
    private TreeMap<Integer, List<Node>> map;

    public MaxStack2() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        insertAtTail(node);
        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node node = removeLast();
        removeFromMap(node);
        return node.val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> nodes = map.get(max);
        Node node = nodes.remove(nodes.size() - 1);
        removeNode(node);
        if (nodes.isEmpty()) map.remove(max);
        return max;
    }

    // ========== Helpers ==========

    private void insertAtTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    private Node removeLast() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeFromMap(Node node) {
        List<Node> nodes = map.get(node.val);
        nodes.remove(nodes.size() - 1);
        if (nodes.isEmpty()) map.remove(node.val);
    }
}

