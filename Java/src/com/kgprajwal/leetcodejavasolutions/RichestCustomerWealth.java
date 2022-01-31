package com.kgprajwal.leetcodejavasolutions;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int n = accounts.length;
        for (int i = 0; i < n; i++) {
            int amount = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                amount += accounts[i][j];
            }
            max = Math.max(max, amount);
        }
        return max;
    }
}
