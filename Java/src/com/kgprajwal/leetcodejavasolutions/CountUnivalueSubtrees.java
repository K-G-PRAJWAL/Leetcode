package com.kgprajwal.leetcodejavasolutions;

public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = {0};
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }
        boolean leftVal = helper(root.left, count);
        boolean rightVal = helper(root.right, count);
        if (leftVal && rightVal) {
            if (
                    (root.left != null && root.left.val != root.val) || (root.right != null && root.right.val != root.val)
            ) return false;
            count[0]++;
            return true;
        }
        return false;
    }
}
