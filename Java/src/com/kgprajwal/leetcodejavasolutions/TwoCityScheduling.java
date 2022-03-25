package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (x, y) -> (x[0] - x[1]) - (y[0] - y[1]));

        int totalCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            totalCost += costs[i][0] + costs[i + costs.length / 2][1];
        }
        return totalCost;
    }
}
