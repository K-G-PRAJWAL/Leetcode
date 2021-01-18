package com.kgprajwal.leetcodejavasolutions;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        System.out.println(w.exist(new char[][]{
                {'A', 'B', 'C', 'D'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    boolean check(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '#';
        boolean result = check(board, i - 1, j, word, ind + 1) ||
                check(board, i, j - 1, word, ind + 1) ||
                check(board, i, j + 1, word, ind + 1) ||
                check(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }
}
