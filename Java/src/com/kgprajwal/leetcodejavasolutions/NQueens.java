package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(board, 0, ans);
        return ans;
    }

    private static void dfs(char[][] board, int colIdx, List<List<String>> ans) {
        if(colIdx== board.length) {
            ans.add(construct(board));
            return;
        }
        for(int i=0;i<board.length;i++) {
            if(validate(board, i, colIdx)) {
                board[i][colIdx] = 'Q';
                dfs(board, colIdx+1, ans);
                board[i][colIdx] = '.';
            }
        }
    }

    private static boolean validate(char[][] board, int x, int y) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<y;j++) {
                if(board[i][j]=='Q' && (x==i || x+j==y+i || x+y==i+j)) return false;
            }
        }
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> ans = new LinkedList<String>();
        for(int i=0;i<board.length;i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
