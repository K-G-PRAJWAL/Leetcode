package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxStreak = 0;
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            s.add(i);
        }
        for (int i : s) {
            if (!s.contains(i - 1)) {
                int curr = i;
                int streak = 1;
                while (s.contains(curr + 1)) {
                    curr += 1;
                    streak += 1;
                }
                maxStreak = Math.max(streak, maxStreak);
            }
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence o = new LongestConsecutiveSequence();
        System.out.println(o.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
