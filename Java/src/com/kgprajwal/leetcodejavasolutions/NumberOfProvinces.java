package com.kgprajwal.leetcodejavasolutions;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}
