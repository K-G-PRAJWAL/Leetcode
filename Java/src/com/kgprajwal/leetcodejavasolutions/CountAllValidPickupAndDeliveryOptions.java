package com.kgprajwal.leetcodejavasolutions;

public class CountAllValidPickupAndDeliveryOptions {
    public int countOrders(int n) {
        long ans = 1;
        for (int i = 1; i <= n; ++i) {
            ans *= i;
            ans *= (2 * i - 1);
            ans %= 1_000_000_007;
        }
        return (int) ans;
    }
}
