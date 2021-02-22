package dp.greedy;

/**
 * @author ShaneTang
 * @create 2021-02-22 11:17
 */
public class StockInfinity {

    public int maxProfit(int[] prices) {
        // write code here
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
