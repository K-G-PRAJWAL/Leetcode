package com.kgprajwal.leetcodejavasolutions;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        boolean visited[][] = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, visited, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y, boolean[][] visited, int dis) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == -1)
            return;
        if (visited[x][y] || dis > rooms[x][y]) return;
        rooms[x][y] = Math.min(rooms[x][y], dis);
        visited[x][y] = true;
        dfs(rooms, x + 1, y, visited, dis + 1);
        dfs(rooms, x - 1, y, visited, dis + 1);
        dfs(rooms, x, y + 1, visited, dis + 1);
        dfs(rooms, x, y - 1, visited, dis + 1);
        visited[x][y] = false;
    }
}
