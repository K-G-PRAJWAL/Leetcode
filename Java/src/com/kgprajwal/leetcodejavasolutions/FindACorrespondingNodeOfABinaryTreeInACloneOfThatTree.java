package com.kgprajwal.leetcodejavasolutions;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    TreeNode ans, target;

    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) ans = c;
            inorder(o.right, c.right);
        }
    }

    TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }
}
