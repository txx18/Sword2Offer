package others;

/**
 * 求斐波那契数列的第n项
 *
 * @author Shane Tang
 * @create 2019-10-06 16:08
 */
public class FibonacciE1001 {
    /**
     * 方法一：递归
     * @param n 从0开始数
     * @return
     */
    public int getNItemByRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return getNItemByRecursion(n - 1) + getNItemByRecursion(n - 2);
    }

    /**
     * 方法二：循环，动态规划
     * 时间n，空间1
     * @param n 从0开始数
     * @return
     */
    public int getNItemByLoop(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;
        int res = 0;
        // n从2开始做第1次加法
        for (int i = 2; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
