package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;

public class HouseRobberIII {
    HashMap<TreeNode, Integer> rob = new HashMap<>();
    HashMap<TreeNode, Integer> notRob = new HashMap<>();

    public int rob(TreeNode root) {
        return helper(root, false);
    }

    int helper(TreeNode node, boolean parentRobbed) {
        if (node == null) return 0;
        if (parentRobbed) {
            if (rob.containsKey(node)) return rob.get(node);
            int result = helper(node.left, false) + helper(node.right, false);
            rob.put(node, result);
            return result;
        } else {
            if (notRob.containsKey(node)) return notRob.get(node);
            int robbed = node.val + helper(node.left, true) + helper(node.right, true);
            int notRobbed = helper(node.left, false) + helper(node.right, false);
            int result = Math.max(robbed, notRobbed);
            notRob.put(node, result);
            return result;
        }
    }
}
