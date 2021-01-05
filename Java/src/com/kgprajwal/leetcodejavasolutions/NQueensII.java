package com.kgprajwal.leetcodejavasolutions;

public class NQueensII {
    private static int count = 0;

    public static int totalNQueens(int n) {
        dfs(new int[n], 0, n);
        return count;
    }

    private static void dfs(int[] pos, int step, int n) {
        if(step==n) {
            count++;
            return;
        }
        for(int i=0;i<n;i++) {
            if(valid(pos, step, i)) {
                pos[step] = i;
                dfs(pos, step+1, n);
            }
        }
    }

    private static boolean valid(int[] pos, int row, int col) {
        for(int i=0;i<row;i++) {
            if(pos[i]==col || (row-i==Math.abs(col-pos[i]))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
