package com.kgprajwal.leetcodejavasolutions;

public class BestTimeToBuyAndSellStockII {
    /*public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int peak = prices[0], valley = prices[0];
        int n = prices.length;
        int i=0;
        while(i<n-1) {
            while(i<n-1 && prices[i]>=prices[i+1]) i++;
            valley = prices[i];
            while(i<n-1 && prices[i]<=prices[i+1]) i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }*/

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII o = new BestTimeToBuyAndSellStockII();
        System.out.println(o.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
