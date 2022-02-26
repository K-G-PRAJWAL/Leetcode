package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int endMask = (1 << n) - 1;
        boolean[][] visited = new boolean[n][endMask];
        ArrayList<int[]> q = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!q.isEmpty()) {
            ArrayList<int[]> nextQ = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                int[] currentPair = q.get(i);
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endMask) return 1 + steps;
                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true;
                        nextQ.add(new int[]{neighbor, nextMask});
                    }
                }
            }
            steps++;
            q = nextQ;
        }
        return -1;
    }
}
