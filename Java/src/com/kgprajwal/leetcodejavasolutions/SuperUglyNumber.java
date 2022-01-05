package com.kgprajwal.leetcodejavasolutions;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        int[] cur = new int[primes.length];
        for (int i = 1; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ans[cur[j]] == ans[i - 1]) {
                    cur[j]++;
                }
                ans[i] = Math.min(ans[i], primes[j] * ans[cur[j]]);
            }
        }
        return ans[n - 1];
    }
}
