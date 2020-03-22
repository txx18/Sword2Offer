package recurforcetry;

/**
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表
 * i号物品的重量和价值。给定一个正数bag，表示一个载重bag的袋子，你装的物
 * 品不能超过这个重量。返回你能装下最多的价值是多少？
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
        int res = obj.solution(weights, values, bag);
        System.out.println("res = " + res);
    }

    private int solution(int[] weights, int[] values, int bag) {
        if (weights == null || values == null ||  bag == 0) {
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

    /**
     * 尝试
     * res累加价值的方法
     * 为什么要两个可变参数，因为有两种base case
     *
     * @param i         决定第i个物品
     * @param curWeight 之前的决定，达到的weight
     * @return 最大价值
     */
    private int recur(int i, int curWeight) {
        // base case 1 如果超重，通过后续判断，不加上价值
        if (curWeight > bag) {
            return -1;
        }
        // base case 2 达到总数
        if (i == weights.length) {
            return 0;
        }
        // 两种情况
        // 1、不要i货物
        int case1 = recur(i + 1, curWeight);
        // 2、要i货物
        // case2 不只是下一个下标可能超，而且可能超重，故先尝试后检验
        int case2try = recur(i + 1, curWeight + weights[i]);
        int case2 = 0;
        // 如果重量没超，才真正把价值加上，如果超重，就不会加case2的价值
        if (case2try != -1) {
            case2 = values[i] + case2try;
        }
        // 取两种情况的较大值
        return Math.max(case1, case2);
    }

    /**
     * 把当前价值作为参数的方法
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
