package linkedList.e62;

import zhelper.ListUtils;

import zhelper.ListUtils.*;

/**
 *
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-17 10:39
 */
public class Josephuse {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int res = lastRemaining(5, 1);
        System.out.println("res = " + res);
    }

    /**
     *
     * @param n
     * @param m NK是说0~m-1报数
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        return stoSolutionCircularList(n , m);
    }

    /**
     * LC
     * @param n
     * @param m LC是说1~ｍ
     * @return
     */
    public static int lastRemaining(int n, int m) {
//        return stoSolutionCircularList(n , m);
//        return cycSolutionRecur(n , m);
        return stoSolutionLoop(n, m);
    }

    /**
     * 执行用时 :
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 57.33%
     * 的用户
     * 内存消耗 :
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param n
     * @param m
     * @return
     */
    private static int stoSolutionLoop(int n, int m) {
        // 防御
        if (n < 1 || m < 1) {
            return -1;
        }
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    /**
     * 执行用时 :
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 44.00%
     * 的用户
     * 内存消耗 :
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param n
     * @param m
     * @return
     */
    public static int cycSolutionRecur(int n, int m) {
        if (n == 0) /* 特殊输入的处理 */
            return -1;
        if (n == 1) /* 递归返回条件 */
            return 0;
        return (cycSolutionRecur(n - 1, m) + m) % n;
    }


    /**
     * NK通过，
     * TODO LC超时
     * 最后执行的输入：
     * 70866
     * 116922
     * @param n
     * @param m
     * @return
     */
    private static int stoSolutionCircularList(int n, int m) {
        // 防御
        if (n < 1 || m < 1) {
            return -1;
        }
        // 定义一个size为n的环形链表
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = newHead.next;
//        ListUtils.printSingleList(newHead.next);
        // 遍历环形链表，依次删除第m个数
        cur = newHead.next;
        int step = n - 1;
        // 最终结果只剩一个数
        while (cur.next != cur) {
            // cur来到待删除的前一个数字
            // 如果要删除第一个数字m=1
            if (m == 1) {
                for (int i = 0; i < step; i++) {
                    cur = cur.next;
                }
                // 跨越并移动
                cur.next = cur.next.next;
                cur = cur.next;
                // 下一次要少转一格
                step--;
            }
            else {
                // m>=2时
                for (int i = 0; i < m - 2; i++) {
                    cur = cur.next;
                }
                // 跨越并移动
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        // 取出最后剩下的数
        return cur.val;
    }


}
