package greedy;

/**
 * @author ShaneTang
 * @create 2021-02-21 22:43
 */
public class StockOnce {

    public int maxProfit(int[] prices) {
        // write code here
        int res = 0;
        int min = Integer.MAX_VALUE; // 不是0
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }
        return res;
    }
}
