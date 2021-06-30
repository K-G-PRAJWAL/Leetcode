package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] idx = new int[26];
        for (int i = 0; i < s.length(); ++i)
            idx[s.charAt(i) - 'a'] = i;
        int j = 0, k = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < s.length(); ++i) {
            j = Math.max(j, idx[s.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - k + 1);
                k = i + 1;
            }
        }
        return ans;
    }
}
