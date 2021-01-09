package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int cnt = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans[rowStart][i] = cnt;
                cnt++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                ans[i][colEnd] = cnt;
                cnt++;
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans[rowEnd][i] = cnt;
                    cnt++;
                }
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans[i][colStart] = cnt;
                    cnt++;
                }
            }
            colStart++;
        }
        return ans;
    }

    public static void main(String[] args) {
        for(int[] i : generateMatrix(3)) System.out.println(Arrays.toString(i));
    }
}
