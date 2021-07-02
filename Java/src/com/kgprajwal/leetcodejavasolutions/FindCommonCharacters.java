package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < words[0].length(); i++) cnt[words[0].charAt(i) - 'a']++;
        for (int i = 1; i < words.length; i++) {
            int[] curr = new int[26];
            for (int j = 0; j < words[i].length(); j++) curr[words[i].charAt(j) - 'a']++;
            for (int j = 0; j < 26; j++) if (curr[j] < cnt[j]) cnt[j] = curr[j];
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < cnt[i]; j++)
                ans.add(Character.toString((char) ('a' + i)));
        return ans;
    }
}
