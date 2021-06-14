package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) set.add(candy);
        if (set.size() > n / 2) return n / 2;
        else return set.size();
    }
}
