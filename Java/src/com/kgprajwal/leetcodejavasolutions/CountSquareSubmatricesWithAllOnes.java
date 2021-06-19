package com.kgprajwal.leetcodejavasolutions;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) ans += 1;
                    else {
                        int val = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + matrix[i][j];
                        ans += val;
                        matrix[i][j] = val;
                    }
                }
            }
        }
        return ans;
    }
}
