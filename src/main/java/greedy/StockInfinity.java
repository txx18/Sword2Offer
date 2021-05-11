package greedy;

/**
 * @author ShaneTang
 * @create 2021-02-22 11:17
 */
public class StockInfinity {

    public int maxProfit(int[] prices) {
        // write code here
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                res += profit;
            }
        }
        return res;
    }
}
