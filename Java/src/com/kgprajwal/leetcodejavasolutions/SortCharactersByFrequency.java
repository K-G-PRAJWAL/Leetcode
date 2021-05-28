package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class SortCharactersByFrequency {
    /*
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                ans.append(e.getKey());
        }
        return ans.toString();
    }
     */

    // Alternate
    public String frequencySort(String s) {
        int[][] cnt = new int[256][2];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)][0] = s.charAt(i);
            cnt[s.charAt(i)][1]++;
        }
        Arrays.sort(cnt, (a, b) -> (b[1] - a[1]));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i][1] > 0) {
                ans.append((char) cnt[i][0]);
                cnt[i][1]--;
            }
        }
        return ans.toString();
    }
}
