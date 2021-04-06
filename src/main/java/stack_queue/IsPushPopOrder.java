package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-02-11 22:05
 */
public class IsPushPopOrder {

    /**
     * 通过LC
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            // pop之前的都要push
            stack.push(pushed[pushIndex]);
            while (!stack.isEmpty() && popped[popIndex] == stack.peek()) { // 注意while
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
