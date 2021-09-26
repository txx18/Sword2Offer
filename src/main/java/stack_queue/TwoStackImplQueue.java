package stack_queue;

import java.util.Stack;

/**
 * @author ShaneTang
 * @create 2021-02-04 22:05
 */
public class TwoStackImplQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public TwoStackImplQueue() {
        // stack1 = new Stack<Integer>();
        // stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
