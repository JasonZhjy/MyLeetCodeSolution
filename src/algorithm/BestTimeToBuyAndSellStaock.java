package algorithm;

/**
 * 120.
 */
public class BestTimeToBuyAndSellStaock {
    /**
     * dp[i + 1] = max{dp[i], prices[i + 1] - minPrice}
     * minPrice是区间[0, 1, 2]内最低价格
     * <p>
     * res = max{dp[0], dp[1], dp[2], ..., dp[n - 1]} (dp[0] not exist)
     *
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int res = Math.max(prices[1] - prices[0], 0), minPrice = prices[0];
        for (int i = 2; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (res < prices[i] - minPrice) {
                res = prices[i] - minPrice;
            }
        }

        return res;
    }

    /**
     * DP 局部最优和全局最优解法
     * local[i + 1] = max{local[i] + prices[i + 1] - prices[i], 0}
     * global[i + 1] = max{global[i], local[i + 1]}
     *
     * @param prices
     * @return
     */
    public int maxProfit2 (int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int global = 0, local = 0;
        for (int i = 1; i < prices.length; i++) {
            local = Math.max(local + prices[i] - prices[i - 1], 0);
            global = Math.max(global, local);
        }

        return global;
    }

}
