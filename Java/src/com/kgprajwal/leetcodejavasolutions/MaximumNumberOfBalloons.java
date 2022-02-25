package com.kgprajwal.leetcodejavasolutions;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for (int i = 0; i < text.length(); i++) chars[text.charAt(i) - 'a']++;

        int min = chars[1];
        min = Math.min(min, chars[0]);
        min = Math.min(min, chars[11] / 2);
        min = Math.min(min, chars[14] / 2);
        min = Math.min(min, chars[13]);

        return min;
    }
}
