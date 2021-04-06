package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[q.peek()];
            }
        }
        return ans;
    }
}
