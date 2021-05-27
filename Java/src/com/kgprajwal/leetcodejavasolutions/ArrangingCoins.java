package com.kgprajwal.leetcodejavasolutions;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long l = 0, r = n;
        long sum, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sum = mid * (mid + 1) / 2;
            if (sum == n) return (int) mid;
            if (sum > n) r = mid - 1;
            else l = mid + 1;
        }
        return (int) r;
    }

    /* Math Shortcut
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
     */
}
