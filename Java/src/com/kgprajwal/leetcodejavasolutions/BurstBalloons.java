package com.kgprajwal.leetcodejavasolutions;

import java.util.Scanner;
import java.lang.Math;

// Combines the concept of Divide & Conquer + DP + Sliding Window  (MCM)
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Padding the array with 1's on either ends
        int[] paddedArr = new int[n + 2];
        paddedArr[0] = 1;
        paddedArr[n + 1] = 1;
        for (int i = 1; i <= n; i++) paddedArr[i] = nums[i-1];

        int[][] dp = new int[n + 2][n + 2];

        // For each window size
        for (int winSize = 1; winSize <= n; winSize++) {
            // Set left and right for the window indexes
            for (int l = 1; l <= n - winSize + 1; l++) {
                int r = l + winSize - 1;
                for (int i = l; i <= r; i++) {
                    dp[l][r] = Math.max(dp[l][r], paddedArr[l - 1] * paddedArr[i] * paddedArr[r + 1] + dp[l][i - 1] + dp[i + 1][r]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        BurstBalloons res = new BurstBalloons();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        res.maxCoins(arr);
    }
}
