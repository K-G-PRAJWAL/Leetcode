package com.kgprajwal.leetcodejavasolutions;

public class SumOfLeftLeaves {
    // Recursive
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }

    // Iterative
    /*
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.empty()) {
            TreeNode node = stk.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) ans += node.left.val;
                else stk.push(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) stk.push(node.right);
            }
        }
        return ans;
    }
    */
}
