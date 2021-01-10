package com.kgprajwal.leetcodejavasolutions;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        // Mathematically
//        if(m==1 || n==1) return 1;
//        m -= 1;
//        n -= 1;
//        if(m<n)  {
//            m = m+n;
//            n = m-n;
//            m = m-n;
//        }
//        long ans = 1;
//        int j = 1;
//        for(int i=m+1; i<=m+n; i++, j++) {
//            ans *= i;
//            ans /= j;
//        }
//        return (int)ans;

        // DP
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) dp[i][0] = 1;
        for(int i=0;i<n;i++) dp[0][i] = 1;
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
