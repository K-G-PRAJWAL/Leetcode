package com.kgprajwal.leetcodejavasolutions;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();
        System.out.println(o.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
