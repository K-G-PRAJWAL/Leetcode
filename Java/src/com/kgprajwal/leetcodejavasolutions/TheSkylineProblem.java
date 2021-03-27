package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(Arrays.asList(b[0], -b[2]));
            height.add(Arrays.asList(b[1], b[2]));
        }
        Collections.sort(height, (a, b) -> {
            if (!a.get(0).equals(b.get(0)))
                return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        Integer prev = 0;
        for (List<Integer> h : height) {
            if (h.get(1) < 0) {
                pq.offer(-h.get(1));
            } else {
                pq.remove(h.get(1));
            }
            Integer cur = pq.peek();
            if (!prev.equals(cur)) {
                result.add(Arrays.asList(h.get(0), cur));
                prev = cur;
            }
        }
        return result;
    }
}
