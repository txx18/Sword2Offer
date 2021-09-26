package stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ShaneTang
 * @create 2021-02-11 12:01
 */
public class DesignGetStackMin {

    Deque<Integer> dataStack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        dataStack.push(node);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), node));
            return;
        }
        minStack.push(node);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
