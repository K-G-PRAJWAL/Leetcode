package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        int l1 = nums1.length, l2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (l1 == 0 || l2 == 0 || k == 0) return ans;
        for (int i = 0; i < Math.min(l1, k); i++)
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        for (int i = 0; i < Math.min(l1 * l2, k); i++) {
            int[] curr = heap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(curr[0]);
            pair.add(curr[1]);
            ans.add(pair);
            if (curr[2] < l2 - 1) {
                int idx = curr[2] + 1;
                heap.offer(new int[]{curr[0], nums2[idx], idx});
            }
        }
        return ans;
    }
}
