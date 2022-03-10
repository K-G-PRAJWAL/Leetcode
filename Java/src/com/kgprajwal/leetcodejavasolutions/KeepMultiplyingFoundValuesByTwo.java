package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;

public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n >= original) set.add(n);
        }
        while (true) {
            if (set.contains(original)) original *= 2;
            else break;
        }
        return original;
    }
}
