package com.kgprajwal.leetcodejavasolutions;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int m = -1;
        int n = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (word1.equals(s)) {
                m = i;
                if (n != -1)
                    min = Math.min(min, m - n);
            } else if (word2.equals(s)) {
                n = i;
                if (m != -1)
                    min = Math.min(min, n - m);
            }
        }
        return min;
    }
}
