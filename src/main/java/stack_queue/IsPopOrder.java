package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-02-11 22:05
 */
public class IsPopOrder {

    /**
     * NK
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            // pop之前的都要push
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty() && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

//    /**
//     * LC
//     *
//     * @param pushed
//     * @param popped
//     * @return
//     */
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        int n = pushed.length;
//        Deque<Integer> stack = new LinkedList<>();
//        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
//            stack.push(pushed[pushIndex]);
//            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
//                stack.pop();
//                popIndex++;
//            }
//        }
//        return stack.isEmpty();
//    }
}
