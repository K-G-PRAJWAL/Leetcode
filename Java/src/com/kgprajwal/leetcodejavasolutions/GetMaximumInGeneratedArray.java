package com.kgprajwal.leetcodejavasolutions;

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int ans = 1;
        for (int i = 1; (2 * i + 1) <= n; i++) {
            arr[2 * i] = arr[i];
            arr[2 * i + 1] = arr[i] + arr[i + 1];
            ans = Math.max(ans, arr[2 * i + 1]);
        }
        return ans;
    }
}
