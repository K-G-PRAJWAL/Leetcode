package com.kgprajwal.leetcodejavasolutions;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int ans = 0;
        int x = 1;
        while (n != 0) {
            if (n % 2 == 0) ans += x;
            n /= 2;
            x *= 2;
        }
        return ans;
    }

    // Alternative solution
    public int bitwiseComplement2(int n) {
        int ans = 1;
        while (n > ans) {
            ans = ans * 2 + 1;
        }
        return ans ^ n;
    }
}
