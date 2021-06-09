package com.kgprajwal.leetcodejavasolutions;

public class Minesweeper {
    private int hasMine(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return 0;
        return board[i][j] == 'M' ? 1 : 0;
    }

    private int findAdjMineNum(char[][] board, int i, int j) {
        return hasMine(board, i - 1, j - 1) +
                hasMine(board, i - 1, j) +
                hasMine(board, i - 1, j + 1) +
                hasMine(board, i, j - 1) +
                hasMine(board, i, j + 1) +
                hasMine(board, i + 1, j - 1) +
                hasMine(board, i + 1, j) +
                hasMine(board, i + 1, j + 1);
    }

    private void updateOneSquare(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != 'E')
            return;
        int adjMineNum = findAdjMineNum(board, i, j);
        if (adjMineNum > 0)
            board[i][j] = (char) ('0' + adjMineNum);
        else {
            board[i][j] = 'B';
            updateOneSquare(board, i - 1, j - 1);
            updateOneSquare(board, i - 1, j);
            updateOneSquare(board, i - 1, j + 1);
            updateOneSquare(board, i, j - 1);
            updateOneSquare(board, i, j + 1);
            updateOneSquare(board, i + 1, j - 1);
            updateOneSquare(board, i + 1, j);
            updateOneSquare(board, i + 1, j + 1);
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];
        if (board[i][j] == 'M')
            board[i][j] = 'X';
        else
            updateOneSquare(board, i, j);
        return board;
    }
}
