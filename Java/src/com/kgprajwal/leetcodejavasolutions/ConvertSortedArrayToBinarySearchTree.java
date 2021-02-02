package com.kgprajwal.leetcodejavasolutions;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    TreeNode helper(int[] nums, int l, int h) {
        if (l > h) return null;
        int mid = (l + h) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid - 1);
        node.right = helper(nums, mid + 1, h);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree obj = new ConvertSortedArrayToBinarySearchTree();
        TreeNode ans = obj.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(ans);
    }
}
