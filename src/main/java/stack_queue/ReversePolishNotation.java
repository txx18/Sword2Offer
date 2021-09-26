package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-06-20 11:39
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation obj = new ReversePolishNotation();
        String[] tokens = new String[]{
                "4", "13", "5", "/", "+"};
        int res = obj.evalRPN(tokens);
        System.out.println("res = " + res);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                int tmp = stack.pop() + stack.pop();
                stack.push(tmp);
            } else if ("-".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int tmp = num2 - num1;
                stack.push(tmp);
            } else if ("*".equals(tokens[i])) {
                int tmp = stack.pop() * stack.pop();
                stack.push(tmp);
            } else if ("/".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int tmp = num2 / num1;
                stack.push(tmp);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
