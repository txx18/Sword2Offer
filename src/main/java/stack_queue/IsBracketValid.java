package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-03-05 23:40
 */
public class IsBracketValid {


    /**
     * 通过LC NK
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // write code here
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 来了一个右括号
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) { // else if (!stack.isEmpty() && c == rightOf(stack.peek()))
                    stack.pop();
                } else {
                    return false; // 必须提前判断不合法
                }
            }
        }
        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        }
        return '{';
    }

    private char rightOf(char c) {
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        }
        return ']';
    }
}
