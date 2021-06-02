package com.kgprajwal.leetcodejavasolutions;

public class NumberComplement {
    public int findComplement(int num) {
        int ans = 0;
        while (ans < num) {
            ans = (ans << 1) | 1;
        }
        return ans - num;
    }
}
