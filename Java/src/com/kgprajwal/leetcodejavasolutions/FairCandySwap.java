package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int Sa = 0, Sb = 0;
        for (int candies : aliceSizes) Sa += candies;
        for (int candies : bobSizes) Sb += candies;
        int mid = (Sb - Sa) / 2;
        Set<Integer> set = new HashSet<>();
        for (int candies : bobSizes) set.add(candies);
        for (int candies : aliceSizes) {
            if (set.contains(candies + mid)) return new int[]{candies, candies + mid};
        }
        return null;
    }
}
