package recur;

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
public class BagMaxPrice {

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

        BagMaxPrice obj = new BagMaxPrice();
//        int res = obj.solution(weights, values, bag);
        int res = obj.knapsack(10, 2, new int[][]{{1, 3}, {10, 4}});
        System.out.println("res = " + res);
    }

    int[][] vw;
    int V;
    int n;

    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        this.vw = vw;
        this.V = V;
        this.n = n;
        return recurNK1(0, 0);
//        return recurNK2(0, V);
    }

    /**
     * 参数少，形式简单，便于改动态规划
     *
     * @param i    决定第i个物品
     * @param curV 之前的决定，达到的体积
     * @return i..之后的最大价值
     */
    private int recurNK1(int i, int curV) {
        // base case 1 如果超体积，无效方案，保证体积不超
        if (curV > V) {
            return -1;
        }
        // base case 2 达到总数，保证数量不超
        if (i == n) {
            return 0;
        }
        // 1、不要i货物
        int res1 = recurNK1(i + 1, curV);
        // 2、要i货物
        // res2 不只是下一个下标可能超，而且可能超重，故先尝试后检验
        int res2try = recurNK1(i + 1, curV + vw[i][0]);
        int res2 = -1;
        // 如果重量没超，才真正把价值加上，如果超重，就不会加case2的价值
        if (res2try != -1) {
            res2 = vw[i][1] + res2try;
        }
        // 取两种情况的较大值
        return Math.max(res1, res2);
    }

    private int recurNK2(int i, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (i == n) {
            return 0;
        }
        int res1 = recurNK1(i + 1, rest);
        int res2 = -1;
        int res2try = recurNK2(i + 1, rest - vw[i][0]);
        if (res2try != -1) {
            res2 = vw[i][1] + res2try;
        }
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
