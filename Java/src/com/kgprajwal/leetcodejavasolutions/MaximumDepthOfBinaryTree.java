package com.kgprajwal.leetcodejavasolutions;

public class MaximumDepthOfBinaryTree {
    /* Recursive */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /* Iterative
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int max = 1;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.push(root);
        depths.push(1);
        while(!nodes.empty()) {
            TreeNode ptr = nodes.pop();
            int currDepth = depths.pop();
            if(ptr.left==null && ptr.right==null) max=Math.max(max, currDepth);
            if(ptr.left!=null) {
                nodes.push(ptr.left);
                depths.push(currDepth+1);
            }
            if(ptr.right!=null) {
                nodes.push(ptr.right);
                depths.push(currDepth+1);
            }
        }
        return max;
    } */

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        System.out.println(m.maxDepth(n1));
    }
}
