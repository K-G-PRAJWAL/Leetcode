package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int maxArea = 0;
        Arrays.fill(right, n - 1);
        for (int i = 0; i < m; i++) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n - 1;
                    rB = j - 1;
                }
            }
            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lB = j + 1;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        System.out.println(m.maximalRectangle(new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1,},
                {1, 0, 0, 1, 0}
        }));
    }
}
