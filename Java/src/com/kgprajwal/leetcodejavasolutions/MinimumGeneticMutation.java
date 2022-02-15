package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] ch = new char[]{'A', 'C', 'G', 'T'};
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>();
        for (String s : bank)
            set.add(s);
        int lvl = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int l = q.size();
            while (l-- > 0) {
                String curr = q.poll();
                if (curr.equals(end)) return lvl;
                char[] charArr = curr.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char prev = charArr[i];
                    for (char c : ch) {
                        charArr[i] = c;
                        String next = new String(charArr);
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    charArr[i] = prev;
                }
            }
            lvl++;
        }
        return -1;
    }
}
