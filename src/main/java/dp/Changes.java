package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-01-17 13:40
 */
public class Changes {

    public static void main(String[] args) {
        Changes obj = new Changes();
        int[] coins = new int[]{1, 2, 5};
        int[] coins2 = new int[]{3, 2, 5};
        int res = obj.solutionDpTable(coins2, 20);
        System.out.println("res = " + res);
    }

    int[] arr;

    int[] coins;


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
     * @param coins
     * @param amount
     * @return
     */
    public int solutionMemoArr(int[] coins, int amount) {
        // write code here
//        this.arr = coins;
        this.coins = coins;
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
        for (int coin : coins) {
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

    private int solutionDpTable(int[] arr, int aim) {
        // write code
        // 根据实际情况初始化dp数组，dp[i]代表 aim==i 时最少的硬币数
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : arr) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[aim] != aim + 1 ? dp[aim] : -1;
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


    /*    *//**
     * 对于列举出重复硬币的题目要求
     *
     * @param coins
     * @param amount
     * @return
     *//*
    private int solutionRecurForce2(int[] coins, int amount) {
        this.coins = coins;
        return recur2(0, amount);
    }

    private int recur2(int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        // rest > 0
        if (index == coins.length) {
            return -1;
        }
        int res1 = recur2(index + 1, rest);
        int res2 = recur2(index + 1, rest - coins[index]);
        if (res1 == -1 && res2 == -1) {
            return -1;
        } else {
            if (res1 == -1) {
                return res2;
            }
            if (res2 == -1) {
                return res1;
            }
            return Math.min(res1, 1 + res2);
        }
    }*/

}
