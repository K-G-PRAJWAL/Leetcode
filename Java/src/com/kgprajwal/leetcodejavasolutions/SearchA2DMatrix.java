package com.kgprajwal.leetcodejavasolutions;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0, end = r * c - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / c][mid % c] == target) return true;
            if (matrix[mid / c][mid % c] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
    }
}
