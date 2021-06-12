package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] visited = new int[n];
        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) ans.add(i);
        }
        return ans;
    }
}
