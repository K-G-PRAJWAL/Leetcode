package com.kgprajwal.leetcodejavasolutions;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        for (String word : words) map.get(word.charAt(0)).addLast(word);
        int count = 0;
        for (char c : s.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}
