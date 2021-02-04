package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(root, ans, tmp, targetSum);
        return ans;
    }

    void helper(TreeNode root, List<List<Integer>> ans, List<Integer> path, int targetSum) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<>(path));
        } else {
            helper(root.left, ans, path, targetSum - root.val);
            helper(root.right, ans, path, targetSum - root.val);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        PathSumII b = new PathSumII();
        System.out.println(b.pathSum(root, 3));
    }
}
