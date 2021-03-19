package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> loop = new HashSet<Integer>();
        int sum, diff;
        while (loop.add(n)) {
            sum = 0;
            while (n > 0) {
                diff = n % 10;
                sum += diff * diff;
                n /= 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }
        return false;
    }
}
