package recur;

import java.util.Stack;

/**
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。
 * 如何实现?
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-18 19:33
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);

        ReverseStack obj = new ReverseStack();
        obj.solution(stack);
        System.out.println("stack = " + stack);
    }

    private void solution(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // 获得原来的栈底并下沉
        int bottom = getBottomAndSink(stack);
        // 递归进行，最深层是原来的栈顶return
        solution(stack);
        // 递归调用到最后，现在已经有了原来的栈顶，开始一边push一边弹递归栈，一直到原来的栈底，完成逆序
        stack.push(bottom);

    }

    /**
     * 弹出栈顶并且把剩下的元素下沉
     *
     * @param stack
     * @return
     */
    private Integer getBottomAndSink(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        }
        int bottom = getBottomAndSink(stack);
        stack.push(res);
        return bottom;
    }
}
