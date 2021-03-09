package recur.dp;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-03-09 15:54
 */
public class ChangesMethodCount {

    public static void main(String[] args) {
        ChangesMethodCount obj = new ChangesMethodCount();
        int[] coins = new int[]{1, 2, 5};
        int res = obj.solutionRecur(5, coins);
        System.out.println("res = " + res);
    }

    int[] coinVals;

    public int solutionRecur(int amount, int[] coins) {
        this.coinVals = coins;
        return dp(0, amount);
    }

    /**
     * @param index
     * @param rest
     * @return 可以自由使用arr[index...]的方法数
     */
    private int dp(int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == coinVals.length) {
            return rest == 0 ? 1 : 0;
        }
        int res = 0;
        // 枚举行为
        for (int count = 0; coinVals[index] * count <= rest; count++) {
            res += dp(index + 1, rest - (coinVals[index] * count));
        }
        return res;
    }

    int[][] cache;

    /**
     * 通过LC
     *
     * @param amount
     * @param coins
     * @return
     */
    public int solutionDpCache(int amount, int[] coins) {
        this.coinVals = coins;
        this.cache = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dpCache(0, amount);
    }

    private int dpCache(int index, int rest) {
/*        if (rest < 0) {
            return 0;
        }*/
        if (cache[index][rest] != -1) {
            return cache[index][rest];
        }
        if (index == coinVals.length) {
            cache[index][rest] = rest == 0 ? 1 : 0;
            return cache[index][rest];
        }
        int res = 0;
        for (int count = 0; coinVals[index] * count <= rest; count++) {
            res += dpCache(index + 1, rest - (coinVals[index] * count));
        }
        cache[index][rest] = res;
        return cache[index][rest];
    }

    public int solutionDpTable(int amount, int[] coins) {
        int N = coins.length;
        int M = amount;
        int[][] dp = new int[N + 1][M + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            // 枚举行为
            for (int rest = 0; rest <= M; rest++) { // 不能反过来呀
                int res = 0;
                for (int count = 0; coins[index] * count <= rest; count++) {
                    // 依赖下方格子 & 左边格子
                    res += dp[index + 1][rest - (coins[index] * count)];
                }
                dp[index][rest] = res;
            }
        }
        return dp[0][M];
    }

    public int solutionDpOpt(int amount, int[] coins) {
        int N = coins.length;
        int M = amount;
        int[][] dp = new int[N + 1][M + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            // 枚举行为
            for (int rest = 0; rest <= M; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) { // >= 0
                    dp[index][rest] += dp[index][rest - coins[index]];
                }
            }
        }
        return dp[0][M];
    }
}
