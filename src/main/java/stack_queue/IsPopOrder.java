package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-02-11 22:05
 */
public class IsPopOrder {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
