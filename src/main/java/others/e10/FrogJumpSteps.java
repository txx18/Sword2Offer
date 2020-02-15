package others.e10;

/**
 * 青蛙跳台阶问题
 *
 * @author Shane Tang
 * @create 2019-10-06 17:08
 */
public class FrogJumpSteps {

    /**
     * 方法一：递归
     * @param n 从1开始数
     * @return
     */
    public int frogByRecursion(int n){
        if(n <= 2){
            return n;
        }
        return frogByRecursion(n - 1) + frogByRecursion(n - 2);
    }

    /**
     * 方法二：循环
     * @param n 从1开始数
     * @return
     */
    public int frogByLoop(int n) {
        if(n <= 2){
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
