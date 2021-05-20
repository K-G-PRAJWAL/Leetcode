package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> sumCount = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (int key : sumCount.keySet()) {
            if (sumCount.get(key) == max) ans.add(key);
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i] = ans.get(i);
        return result;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        int count = sumCount.getOrDefault(sum, 0) + 1;
        sumCount.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }
}
