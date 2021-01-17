package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 求斐波那契数列的第n项
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @create 2019-10-06 16:08
 */
public class FibonacciE1001 {

    public static void main(String[] args) {

        long res = dpTable(19);
//        long res = dp(45);
        System.out.println("res = " + res);
    }

    static int first = 1;
    static int second = 1;

    /**
     * 优化空间
     * 当前状态只跟前两个状态有关
     * 时间n，空间1
     *
     * @param n 从0开始数
     * @return
     */
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int p1 = first;
        int p2 = second;
        int res = 0;
        // i从几开始，到几，要看语境，有的把第0项叫第一项。。
        for (int i = 2; i < n; i++) {
            res = p1 + p2;
            p1 = p2;
            p2 = res;
        }
        return res;
    }

    /**
     *
     * 用dp数组 替换备忘录
     * @param n
     * @return
     */
    public static int dpTable(int n) {
        if (n == 1 || n == 2) {
            return first;
        }
        int[] dp = new int[n + 1];
        dp[1] = first;
        dp[2] = second;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }


    static int[] memoArray;
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibMemoMap(int n) {
        if (n == 1 || n == 2) {
            return first;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        int sum = fibMemoMap(n - 1) + fibMemoMap(n - 2);
        memo.put(n, sum);
        return memo.get(n);
    }

    public static int fibMemoArray(int n) {
        memoArray = new int[n];
        return recurMemoArray(n);
    }

    private static int recurMemoArray(int n) {
        if (n == 1 || n == 2) {
            return first;
        }
        if (memoArray[n - 1] != 0) {
            return memoArray[n - 1];
        }
        memoArray[n - 1] = recurMemoArray(n - 1) + recurMemoArray(n - 2);
        return memoArray[n - 1];
    }

    /**
     * 递归
     * LC 超时
     *
     * @param n 从0开始数f(0) = 0
     * @return
     */
    public int fibForce(int n) {
        if (n <= 1) {
            return n;
        }
        return fibForce(n - 1) + fibForce(n - 2);
    }
}
