package com.kgprajwal.leetcodejavasolutions;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        for (int i = 1; i <= n2; i++) dp[0][i] = i;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                else {
                    int x = dp[i][j];
                    int y = dp[i][j + 1];
                    int z = dp[i + 1][j];
                    dp[i + 1][j + 1] = x < y ? (x < z ? x : z) : (y < z ? y : z);
                    dp[i + 1][j + 1]++;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
