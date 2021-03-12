package recur.dp.methodcount;

/**
 * 矩形覆盖问题
 *
 * @author Shane Tang
 * @create 2019-10-06 17:25
 */
public class RectangleCover {

    /**
     * 方法一：递归
     *
     * @param length 从1开始数
     * @return
     */
    public int rectangleCoverByRecur(int length) {
        if (length <= 2) {
            return length;
        }
        return rectangleCoverByRecur(length - 1) + rectangleCoverByRecur(length - 2);
    }

    /**
     * 方法二：循环 （跟青蛙跳台阶完全一样）
     *
     * @param length 从1开始数
     * @return
     */
    public int rectangleCoverByLoop(int length) {
        if (length <= 2) {
            return length;
        }
        int pre1 = 1;
        int pre2 = 2;
        int res = 0;
        // n从3开始做第一次加法
        for (int i = 3; i <= length; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}
