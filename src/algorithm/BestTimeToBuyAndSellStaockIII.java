package algorithm;

/**
 * 123. Hard DP Array
 * 分析：这一题约束最多只能买卖两次股票，并且手上最多也只能持有一支股票。因为不能连续买入两次股票，
 * 所以买卖两次肯定分布在前后两个不同的区间。
 * 设p(i) = 区间[0,1,2...i]的最大利润 + 区间[i,i+1,....n-1]的最大利润（式子中两个区间内分别只能有一次买卖，
 * 这就是第一道题的问题），
 * 那么本题的最大利润 = max{p[0],p[1],p[2],...,p[n-1]}。
 * 根据第一题的算法2，我们可以求区间[0,1,2...i]的最大利润；
 * 同理可以从后往前扫描数组求区间[i,i+1,....n-1]的最大利润，其递归式如下：
 * dp[i-1] = max{dp[i], maxprices - prices[i-1]}  ,maxprices是区间[i,i+1,...,n-1]内的最高价格。
 */
public class BestTimeToBuyAndSellStaockIII {
    public int maxProfit (int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        return maxProfit(prices, 2);
    }

    public int maxProfit (int[] prices, int times) {
        for (int time = 0; time <= times; time++) {

        }
        return 0;
    }

    /**
     * 121.
     * dp[i] = max{dp[i - 1], prices[i] - minPrice}
     *
     * @param prices
     * @param beg
     * @param end
     * @return
     */
    public int maxProfit (int[] prices, int beg, int end) {
        if (end - beg < 1) {
            return 0;
        }

        int minPrice = prices[beg], res = 0;
        for (int i = beg + 1; i <= end; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            if (res < prices[i] - minPrice) {
                res = prices[i] - minPrice;
            }
        }
        return res;
    }
}
