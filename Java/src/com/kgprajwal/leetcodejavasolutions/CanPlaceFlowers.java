package com.kgprajwal.leetcodejavasolutions;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == l - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                cnt++;
            }
        }
        return cnt >= n;
    }
}
