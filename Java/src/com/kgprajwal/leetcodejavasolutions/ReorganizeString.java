package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            if (count > (s.length() + 1) / 2) return "";
            map.put(ch, count);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char ch : map.keySet()) pq.add(new int[]{ch, map.get(ch)});
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (ans.length() == 0 || first[0] != ans.charAt(ans.length() - 1)) {
                ans.append((char) first[0]);
                if (--first[1] > 0) pq.add(first);
            } else {
                int[] second = pq.poll();
                ans.append((char) second[0]);
                if (--second[1] > 0) pq.add(second);
                pq.add(first);
            }
        }
        return ans.toString();
    }
}
