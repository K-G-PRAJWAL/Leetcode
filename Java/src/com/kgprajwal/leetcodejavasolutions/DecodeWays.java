package com.kgprajwal.leetcodejavasolutions;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) dp[i] += dp[i - 1];
            if (second >= 10 && second <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("12"));
    }
}
