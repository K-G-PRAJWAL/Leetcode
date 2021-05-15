package com.kgprajwal.leetcodejavasolutions;

public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int curr = 0;
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
