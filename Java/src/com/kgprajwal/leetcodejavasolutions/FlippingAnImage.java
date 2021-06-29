package com.kgprajwal.leetcodejavasolutions;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int c = image[0].length;
        for (int[] r : image) {
            for (int i = 0; i < (c + 1) / 2; i++) {
                int tmp = r[i] ^ 1;
                r[i] = r[c - 1 - i] ^ 1;
                r[c - 1 - i] = tmp;
            }
        }
        return image;
    }
}
