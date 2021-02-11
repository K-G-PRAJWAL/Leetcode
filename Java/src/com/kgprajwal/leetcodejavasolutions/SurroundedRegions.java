package com.kgprajwal.leetcodejavasolutions;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][c - 1] == 'O') helper(board, i, c - 1);
        }
        for (int j = 1; j < c - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[r - 1][j] == 'O') helper(board, r - 1, j);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    void helper(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || board[row][col] != 'O') return;
        board[row][col] = '*';
        helper(board, row + 1, col);
        helper(board, row - 1, col);
        helper(board, row, col - 1);
        helper(board, row, col + 1);
    }

    public static void main(String[] args) {
        SurroundedRegions o = new SurroundedRegions();
        o.solve(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }
}
