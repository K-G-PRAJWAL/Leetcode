package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (!dp.containsKey(n)) {
            List<TreeNode> ans = new LinkedList<>();
            if (n == 1) ans.add(new TreeNode(0));
            else if (n % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    int j = n - 1 - i;
                    for (TreeNode left : allPossibleFBT(i))
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            ans.add(node);
                        }
                }
            }
            dp.put(n, ans);
        }
        return dp.get(n);
    }
}
