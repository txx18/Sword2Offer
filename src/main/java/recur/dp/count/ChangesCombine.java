package recur.dp.count;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-03-09 15:54
 */
public class ChangesCombine {

    public static void main(String[] args) {
        ChangesCombine obj = new ChangesCombine();
        int[] coins = new int[]{1, 2, 5};
        int res = obj.solutionRecur(5, coins);
        System.out.println("res = " + res);
    }

    /**
     * 通过LC
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
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
        if (rest == 0) {
            return 1;
        }
        if (index == coinVals.length) {
            return 0;
        }
        int res = 0;
        // 有枚举行为，是可以斜率优化的
        for (int count = 0; rest - coinVals[index] * count >= 0; count++) {
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
        if (rest == 0) {
            cache[index][rest] = 1;
            return cache[index][rest];
        }
        if (index == coinVals.length) {
            cache[index][rest] = 0;
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
            for (int rest = 0; rest <= M; rest++) { // 可以反过来
                int res = 0;
                // 枚举行为
                for (int count = 0; coins[index] * count <= rest; count++) {
                    // 只依赖下方的格子 & 以左的格子，可以优化
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
                // 斜率优化
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) { // >= 0
                    dp[index][rest] += dp[index][rest - coins[index]];
                }
            }
        }
        return dp[0][M];
    }
}
