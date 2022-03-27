package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] score = new int[rows];
        int j;
        for (int i = 0; i < rows; i++) {
            j = 0;
            for (; j < cols; j++) {
                if (mat[i][j] == 0) break;
            }
            score[i] = j * rows + i;
        }
        Arrays.sort(score);
        for (int i = 0; i < score.length; i++) score[i] = score[i] % rows;
        return Arrays.copyOfRange(score, 0, k);
    }
}
