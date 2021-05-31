package com.kgprajwal.leetcodejavasolutions;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // return Integer.bitCount(x ^ y);

        int ans = 0;
        int xor = x ^ y;
        while (xor > 0) {
            if (xor % 2 == 1) ans++;
            xor >>= 1;
        }
        return ans;
    }
}
