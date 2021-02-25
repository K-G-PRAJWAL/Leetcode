package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int counter = 0, len = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            if (!map.containsKey(cur)) map.put(cur, 0);
            map.put(cur, map.get(cur) + 1);
            if (map.get(cur) == 1) counter++;
            while (counter > 2) {
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) counter--;
                start++;
            }
            len = Math.max(end - start + 1, len);
            end++;
        }
        return len;
    }
}
