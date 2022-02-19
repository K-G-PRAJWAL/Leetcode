package com.kgprajwal.leetcodejavasolutions;

import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 2 != 0) n *= 2;
            min = Math.min(min, n);
            pq.add(n);
        }
        int diff = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int max = pq.remove();
            diff = Math.min(diff, max - min);
            min = Math.min(min, max / 2);
            pq.add(max / 2);
        }
        return Math.min(diff, pq.peek() - min);
    }
}
