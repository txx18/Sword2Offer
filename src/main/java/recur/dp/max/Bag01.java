package recur.dp.max;

import java.util.Arrays;

/**
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表
 * i号物品的重量和价值。给定一个正数bag，表示一个载重bag的袋子，你装的物
 * 品不能超过这个重量。返回你能装下最多的价值是多少？
 * <p>
 * 有描述为重量-价值的
 * 有描述为体积-重量的
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-19 20:51
 */
public class Bag01 {

    int[] weights;
    int[] values;
    int bag;

    public static void main(String[] args) {
/*        int[] weights = {1, 2, 3, 4};
        int[] values = {1, 2, 3, 4};
        int bag = 5;*/

        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 11;

        Bag01 obj = new Bag01();
//        int res = obj.solution(weights, values, bag);
//        int res = obj.solutionDpTable(10, 2, new int[][]{{1, 3}, {10, 4}});
        int res = obj.solutionDpTable(4, 3, new int[][]{{1, 15}, {3, 20}, {4, 30}});
        System.out.println("res = " + res);
    }

    /**
     * dp[i][j] 表示从 下标为[0- i] 的物品里任意取，放进容量为 j 的背包，价值总和最大是多少。
     *
     * @param V
     * @param n
     * @param vw
     * @return
     */
    public int solutionDpTable(int V, int n, int[][] vw) {
        int[][] dp = new int[n][V + 1];
        // 初始化
/*        for (int j = V; j >= vw[0][0]; j--) {
            dp[0][j] = vw[0][1] + dp[0][j - vw[0][0]];
        }*/
        for (int j = vw[0][0]; j <= V; j++) {
            dp[0][j] = vw[0][1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= V; j++) {
                if (j - vw[i][0] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    // 递推公式
                    dp[i][j] = Math.max(dp[i - 1][j], vw[i][1] + dp[i - 1][j - vw[i][0]]);
                }
            }
        }
        return dp[n - 1][V];
    }


    public int solutionDpTableFromRecur(int V, int n, int[][] vw) {
        // write code here
        // dp的含义：选择[0..index][V..0]时的最大重量
        int[][] dp = new int[n + 1][V + 1];
        // 需要初始化 recur.dp[n][...] == 0， 但已经默认为0了
        // 注意这个遍历顺序，已知index == n行，要推index == 0行，应该逆序遍历
        for (int index = n - 1; index >= 0; index--) { // 注意
            for (int rest = 0; rest <= V; rest++) {
                int res1 = dp[index + 1][rest];
                int res2 = -1;
                if (rest - vw[index][0] >= 0) {
                    int res2try = dp[index + 1][rest - vw[index][0]];
                    res2 = vw[index][1] + res2try;
                }
                dp[index][rest] = Math.max(res1, res2);
            }
        }
        return dp[0][V];
    }

    int[][] vw;
    int V;
    int n;


    public int solutionRecur(int V, int n, int[][] vw) {
        // write code here
        this.vw = vw;
        this.V = V;
        this.n = n;
        this.cache = new int[n + 1][V + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
//        return recurNK1(0, 0);
//        return recurNK2(0, V);
        return recurCache(0, V);
    }


    private int recurNK2(int index, int rest) {
        if (rest < 0) {
            // 无效解
            return -1;
        }
        // rest >= 0
        if (index == n) {
            // 不能再产生价值，注意不是“找到1种方法”
            return 0;
        }
        int res1 = recurNK2(index + 1, rest);
        int res2 = -1;
        // 发现 rest - vw[index][0] 可能 <0 越界，所以在base case 判断
        // 我感觉：这种改变参数继续递归的尝试方法，就是隐含的回溯
        int res2try = recurNK2(index + 1, rest - vw[index][0]);
        if (res2try != -1) {
            res2 = vw[index][1] + res2try;
        }
        return Math.max(res1, res2);
    }

    int[][] cache;

    /**
     * 通过NK
     *
     * @param index
     * @param rest
     * @return
     */
    private int recurCache(int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (cache[index][rest] != -1) {
            return cache[index][rest];
        }
        if (index == n) {
            cache[index][rest] = 0;
            return 0;
        }
        int res1 = recurCache(index + 1, rest);
        int res2 = -1;
        // 发现 rest - vw[index][0] 可能 <0 越界，所以在base case 判断
        int res2try = recurCache(index + 1, rest - vw[index][0]);
        if (res2try != -1) {
            res2 = vw[index][1] + res2try;
        }
        cache[index][rest] = Math.max(res1, res2);
        return cache[index][rest];
    }

    /**
     * 通过NK
     *
     * @param index
     * @param rest
     * @return
     */
    private int recurCache2(int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (cache[index][rest] != -1) {
            return cache[index][rest];
        }
        if (index == n) {
            cache[index][rest] = 0;
            return 0;
        }
        int res1 = recurCache2(index + 1, rest);
        int res2 = -1;
        if (rest - vw[index][0] >= 0) {
            res2 = vw[index][1] + recurCache2(index + 1, rest - vw[index][0]);
            ;
        }
        cache[index][rest] = Math.max(res1, res2);
        return cache[index][rest];
    }


    /**
     * 参数少，形式简单，便于改动态规划
     *
     * @param index 决定第i个物品
     * @param curV  之前的决定，达到的体积
     * @return index..之后的最大价值
     */
    private int recurNK1(int index, int curV) {
        // base case 1 如果超体积，无效方案，保证体积不超
        if (curV > V) {
            return -1;
        }
        // base case 2 达到总数，保证数量不超
        if (index == n) {
            return 0;
        }
        // 1、不要i货物
        int res1 = recurNK1(index + 1, curV);
        // 2、要i货物
        // res2 不只是下一个下标可能超，而且可能超重，故先尝试后检验
        int res2try = recurNK1(index + 1, curV + vw[index][0]);
        int res2 = -1;
        // 如果重量没超，才真正把价值加上，如果超重，就不会加case2的价值
        if (res2try != -1) {
            res2 = vw[index][1] + res2try;
        }
        // 取两种情况的较大值
        return Math.max(res1, res2);
    }

    /**
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    private int solution(int[] weights, int[] values, int bag) {
        if (weights == null || values == null || bag == 0) {
            return 0;
        }
        if (weights.length != values.length) {
            return -1;
        }
        this.weights = weights;
        this.values = values;
        this.bag = bag;
        return recur(0, 0);
//        return recurWithCurValue(0, 0, 0);
    }

    private int recur(int i, int curWeight) {
        // base case 1 如果超重，通过后续判断，不加上价值，保证重量不超
        if (curWeight > bag) {
            return -1; // 0
        }
        // base case 2 达到总数，保证下标不超
        if (i == weights.length) {
            return 0;
        }
        // 1、不要i货物
        int res1 = recur(i + 1, curWeight);
        // 2、要i货物
        // res2 不只是下一个下标可能超，而且可能超重，故先尝试后检验
        int res2try = recur(i + 1, curWeight + weights[i]);
        int res2 = 0;
        // 如果重量没超，才真正把价值加上，如果超重，就不会加case2的价值
        if (res2try != -1) {
            res2 = values[i] + res2try;
        }
        // 取两种情况的较大值
        return Math.max(res1, res2);
    }


    /**
     * 可变参数多一个
     *
     * @param i
     * @param curWeight
     * @param curValue
     * @return
     */
    private int recurWithCurValue(int i, int curWeight, int curValue) {
        // base case 1 如果超重，return 0 给价值加0
        if (curWeight > bag) {
            return 0;
        }
        // base case 2
        if (i == weights.length) {
            return curValue;
        }
        // 两种情况取较大值 1、不要i货物 2、要i货物
        int case1 = recurWithCurValue(i + 1, curWeight, curValue);
        // 如果超重，根据basecase1，会返回0，case2也就为0
        int case2 = recurWithCurValue(i + 1, curWeight + weights[i], curValue + values[i]);
        return Math.max(case1, case2);
    }


}
