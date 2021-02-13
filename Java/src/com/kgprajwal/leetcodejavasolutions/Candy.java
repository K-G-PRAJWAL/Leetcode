package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1;
        }
        int total = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            total += candy[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Candy o = new Candy();
        System.out.println(o.candy(new int[]{1, 0, 2}));
    }
}
