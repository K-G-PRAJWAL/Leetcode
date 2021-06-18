package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {
    /*public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char ch : tiles.toCharArray())
            cnt[ch - 'A']++;
        return dfs(cnt);
    }

    int dfs(int[] cnt) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            sum++;
            cnt[i]--;
            sum += dfs(cnt);
            cnt[i]++;
        }
        return sum;
    }*/
    Map<Integer, Integer> memo = new HashMap<>();

    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char ch : tiles.toCharArray())
            cnt[ch - 'A']++;
        return dfs(cnt);
    }

    int dfs(int[] cnt) {
        int key = Arrays.hashCode(cnt);
        if (memo.containsKey(key)) return memo.get(key);
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            sum++;
            cnt[i]--;
            sum += dfs(cnt);
            cnt[i]++;
        }
        memo.put(key, sum);
        return sum;
    }
}
