package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class PathWithMaximumGold {
    int[] directions = new int[]{0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                maxGold = Math.max(maxGold, helper(grid, i, j, r, c, 0, new HashSet<Integer>()));
        return maxGold;
    }

    int helper(int[][] grid, int i, int j, int r, int c, int sum, Set<Integer> visited) {
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) return sum;
        if (!visited.add(i * c + j)) return sum;
        sum += grid[i][j];
        int max = 0;
        for (int k = 0; k < 4; k++)
            max = Math.max(max, helper(grid, i + directions[k], j + directions[k + 1], r, c, sum, visited));
        visited.remove(i * c + j);
        return max;
    }
}
