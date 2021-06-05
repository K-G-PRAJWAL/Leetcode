package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {
    Map<Integer, Integer> map;
    int total, r, c;
    Random rand;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        r = n_rows;
        c = n_cols;
        reset();
    }

    public int[] flip() {
        int idx = rand.nextInt(total--);
        int val = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(total, total));
        map.put(total, val);
        return new int[]{val / c, val % c};
    }

    public void reset() {
        total = r * c;
    }
}
