package com.kgprajwal.leetcodejavasolutions;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        if(board==null) return;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {
                    for(char ch='1';ch<='9';ch++) {
                        if(check(board, i, j, ch)) {
                            board[i][j] = ch;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check(char[][] board, int row, int col, char ch) {
        for(int i=0;i<9;i++) {
            if(board[i][col]!='.' && board[i][col]==ch) return false;
            if(board[row][i]!='.' && board[row][i]==ch) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]!='.' && board[3*(row/3)+i/3][3*(col/3)+i%3]==ch) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        });
    }
}
