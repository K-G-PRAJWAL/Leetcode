package com.kgprajwal.leetcodejavasolutions;

public class BestTimeToBuyAndSellStocksIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            buy[i][0] = sell[i][0] = 0;
        }
        for (int j = 1; j <= k; ++j) {
            buy[0][j] = -prices[0];
            sell[0][j] = 0;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }
        return sell[n - 1][k];
    }
}
