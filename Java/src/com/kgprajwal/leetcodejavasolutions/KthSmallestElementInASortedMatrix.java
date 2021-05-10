package com.kgprajwal.leetcodejavasolutions;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0], h = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                cnt += (j + 1);
            }
            if (cnt < k) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
