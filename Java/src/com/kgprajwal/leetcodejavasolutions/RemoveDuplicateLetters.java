package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;
            if (visited[ch - 'a']) continue;
            while (!stk.isEmpty() && stk.peek() > ch && freq[stk.peek() - 'a'] > 0) {
                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }
            stk.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stk) sb.append(ch);
        return sb.toString();
    }
}
