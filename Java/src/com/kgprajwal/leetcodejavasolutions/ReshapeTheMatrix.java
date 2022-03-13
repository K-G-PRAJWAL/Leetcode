package com.kgprajwal.leetcodejavasolutions;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        /*
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        int[] oneDVector = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                oneDVector[idx++] = mat[i][j];
            }
        }
        idx = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = oneDVector[idx++];
            }
        }
        return ans;
         */
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        int[][] ans = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }

        return ans;
    }
}
