package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    /*public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        return dfs(graph, 0, map);
    }

    List<List<Integer>> dfs(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(node)) return map.get(node);
        List<List<Integer>> ans = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(node);
            ans.add(path);
        } else {
            for (int nextNode : graph[node]) {
                List<List<Integer>> subPaths = dfs(graph, nextNode, map);
                for (List<Integer> path : subPaths) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    ans.add(newPath);
                }
            }
        }
        map.put(node, ans);
        return ans;
    }
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) return null;
        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, n - 1, path, ans);
        return ans;
    }

    void dfs(int[][] graph, int src, int dest, List<Integer> path, List<List<Integer>> ans) {
        if (src == dest) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int node : graph[src]) {
            path.add(node);
            dfs(graph, node, dest, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
