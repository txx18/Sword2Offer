package stack_queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ShaneTang
 * @create 2021-02-11 12:01
 */
public class DesignGetStackMin {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), node));
        } else {
            minStack.push(node);
        }
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
