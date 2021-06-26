package com.kgprajwal.leetcodejavasolutions;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];
        for (int[] edge : edges) {
            int u = dfs(sets, edge[0]);
            int v = dfs(sets, edge[1]);
            if (u == v) return edge;
            sets[u] = v;
        }
        return new int[]{};
    }

    private int dfs(int[] sets, int v) {
        if (sets[v] == 0) return v;
        return dfs(sets, sets[v]);
    }
}
