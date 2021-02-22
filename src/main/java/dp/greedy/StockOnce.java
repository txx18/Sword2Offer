package dp.greedy;

/**
 * @author ShaneTang
 * @create 2021-02-21 22:43
 */
public class StockOnce {

    public int maxProfit(int[] prices) {
        // write code here
        int res = 0;
        int curMin = Integer.MAX_VALUE;
        for (int price : prices) {
            curMin = Math.min(curMin, price);
            res = Math.max(res, price - curMin);
        }
        return res;
    }
}
