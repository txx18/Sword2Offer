package dp;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-21 17:33
 */
public class GreatestSumOfSubArray {

    public static void main(String[] args) {
        GreatestSumOfSubArray obj = new GreatestSumOfSubArray();
        int res = obj.solutionDpTable(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println("res = " + res);
    }

    public int solutionDpOpt(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            if (sum <= 0) {
                sum = val;
            } else {
                sum += val;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public int solutionDpTable(int[] array) {
        int n = array.length;
        // 初始化为原数组copy
        int[] dp = Arrays.copyOf(array, n);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) { // 注意公式的含义，不是array[i - 1]
                dp[i] += dp[i - 1];
            }
//            dp[i] += Math.max(dp[i - 1], 0); // 替换if的写法
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
