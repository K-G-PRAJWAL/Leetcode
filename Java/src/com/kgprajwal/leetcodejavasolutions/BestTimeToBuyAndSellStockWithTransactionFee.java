package com.kgprajwal.leetcodejavasolutions;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int amt = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            amt = Math.max(amt, hold + prices[i] - fee);
            hold = Math.max(hold, amt - prices[i]);
        }
        return amt;
    }
}
