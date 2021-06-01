package com.kgprajwal.leetcodejavasolutions;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int ones = 0, zeroes = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') ones++;
                else zeroes++;
            }
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    if (ones <= j && zeroes <= i)
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
