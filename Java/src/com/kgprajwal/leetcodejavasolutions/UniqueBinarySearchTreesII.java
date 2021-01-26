package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftsub = helper(start, i - 1);
            List<TreeNode> rightsub = helper(i + 1, end);
            for (TreeNode left : leftsub) {
                for (TreeNode right : rightsub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        System.out.println(u.generateTrees(3));
    }
}
