package com.kgprajwal.leetcodejavasolutions;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    TreeNode helper(int[] nums, int l, int r) {
        if (l == r) return null;
        int max = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(nums, l, max);
        root.right = helper(nums, max + 1, r);
        return root;
    }

    int max(int[] nums, int l, int r) {
        int max = l;
        for (int i = l; i < r; i++)
            if (nums[max] < nums[i]) max = i;
        return max;
    }
}
