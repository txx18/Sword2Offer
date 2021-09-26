package dp;

import dp.min.ChangesMinCount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneTang
 * @create 2021-03-09 15:54
 */
public class Changes {

    static class MinCoinCount {
        public static void main(String[] args) {
            MinCoinCount obj = new MinCoinCount();
            int[] coins = new int[]{1, 2, 5};
            int[] coins2 = new int[]{3, 2, 5};
            int res = obj.solutionRecurForce(coins2, 20);
            System.out.println("res = " + res);
        }

        /**
         * 通过LC
         *
         * @param coins
         * @param amount
         * @return
         */
        private int dpTable(int[] coins, int amount) {
            // write code
            int n = coins.length;
            // 根据实际情况初始化dp数组，dp[i]代表 amount==i 时最少的硬币数
            int[] dp = new int[amount + 1];
            // 求最少，初始化为极大值 amount + 1
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j < amount + 1; j++) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
            return dp[amount] != amount + 1 ? dp[amount] : -1;
        }


        private int dpTableLBLD(int amount) {
            // 初始化dp数组
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coinVals) {
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return dp[amount] != amount + 1 ? dp[amount] : -1;
        }

        int[] arr;

        int[] coinVals;

        int amount;


        private int solutionRecurForce(int[] coins, int amount) {
            this.coinVals = coins;
            this.amount = amount;
            return dp(0, amount);
        }

        /**
         * @param index
         * @param rest
         * @return 最小货币数
         */
        private int dp(int index, int rest) {
            if (rest < 0) {
                // 无效解
                return -1;
            }
            if (rest == 0) {
                // 有解，0个
                return 0;
            }
            // rest > 0
            if (index == coinVals.length) {
                return -1;
            }
            int res = -1;
            int res2try = -1;
            for (int count = 0; coinVals[index] * count <= rest; count++) {
                res2try = dp(index + 1, rest - (coinVals[index] * count));
                if (res2try != -1) {
                    if (res == -1) {
                        res = count + res2try;
                    } else {
                        res = Math.min(res, res2try + count);
                    }
                }
            }
            return res;
        }

        int[][] cache;

        /**
         * 通过LC
         *
         * @param coins
         * @param amount
         * @return
         */
        private int solutionRecurCache(int[] coins, int amount) {
            this.coinVals = coins;
            this.amount = amount;
            cache = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < cache.length; i++) {
                Arrays.fill(cache[i], -2);
            }
            return dpCache(0, amount);
        }

        private int dpCache(int index, int rest) {
            if (rest < 0) {
                // 无效解
                return -1;
            }
            if (cache[index][rest] != -2) {
                return cache[index][rest];
            }
            if (rest == 0) {
                // 有解，0个
                cache[index][rest] = 0;
                return 0;
            }
            // rest > 0
            if (index == coinVals.length) {
                cache[index][rest] = -1;
                return -1;
            }
            int res = -1;
            int res2try = -1;
            for (int count = 0; coinVals[index] * count <= rest; count++) {
                res2try = dpCache(index + 1, rest - (coinVals[index] * count));
                if (res2try != -1) {
                    if (res == -1) {
                        res = count + res2try;
                    } else {
                        res = Math.min(res, res2try + count);
                    }
                }
            }
            cache[index][rest] = res;
            return cache[index][rest];
        }


        private int solutionRecurForce1(int[] coins, int amount) {
            // base case
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            // 初始最大值
            int curRes = amount + 1;
            for (int coin : coins) {
                if (amount - coin < 0) {
                    continue;
                }
                int preRes = solutionRecurForce1(coins, amount - coin);
                if (preRes == -1) {
                    continue;
                }
                curRes = Math.min(curRes, 1 + preRes);
            }
            // 更新res
            return curRes == amount + 1 ? -1 : curRes;
        }

        int[] memoArr;

        /**
         * 不通过LC
         *
         * @param coins
         * @param amount
         * @return
         */
        public int solutionMemoArr(int[] coins, int amount) {
            // write code here
//        this.arr = coins;
            this.coinVals = coins;
            memoArr = new int[amount + 1];
            Arrays.fill(memoArr, -1);
            recurMemoArr(amount);
            return memoArr[amount];
        }

        private int recurMemoArr(int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (memoArr[amount] != -1) {
                return memoArr[amount];
            }
            // 初始最大值
            int curRes = amount + 1;
            for (int coin : coinVals) {
//            if (amount - coin < 0) {
//                continue;
//            }
                int preRes = recurMemoArr(amount - coin);
                if (preRes == -1) {
                    continue;
                }
                curRes = Math.min(curRes, 1 + preRes);
            }
            // 更新res
            memoArr[amount] = curRes == amount + 1 ? -1 : curRes;
            return memoArr[amount];
        }


        Map<Integer, Integer> memoMap = new HashMap<>();

        private int dpMemoMap(int aim) {
            if (aim == 0) {
                return 0;
            }
            if (memoMap.get(aim) != -1) {
                return memoMap.get(aim);
            }
            int res = Integer.MAX_VALUE;
            for (int coin : arr) {
                if (aim - coin < 0) {
                    continue;
                }
                int subRes = dpMemoMap(aim - coin);
                if (subRes == -1) {
                    continue;
                }
                res = Math.min(res, 1 + subRes);
            }
            memoMap.put(aim, res == Integer.MAX_VALUE ? -1 : res);
            return memoMap.get(aim);
        }
    }


    class CombineCount {
        /**
         * 通过LC
         *
         * @param amount
         * @param coins
         * @return
         */
        public int dpTable(int amount, int[] coins) {
            // dp[i] 定义为 coin下标为[0, i] 下的组合数
            int[] dp = new int[amount + 1];
            int n = coins.length;
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j < amount + 1; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }


        public int solutionDpTableZS(int amount, int[] coins) {
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

        public int solutionDpOptZS(int amount, int[] coins) {
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
    }
}
