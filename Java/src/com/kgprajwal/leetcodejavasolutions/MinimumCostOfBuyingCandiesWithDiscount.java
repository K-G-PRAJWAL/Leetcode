package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int i = cost.length - 1;
        while (i > 1) {
            total += cost[i] + cost[i - 1];
            i -= 3;
        }
        while (i >= 0) total += cost[i--];
        return total;
    }
}
