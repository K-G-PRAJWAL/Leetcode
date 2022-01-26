package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        while (root1 != null || root2 != null || !stk1.isEmpty() || !stk2.isEmpty()) {
            while (root1 != null) {
                stk1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stk2.push(root2);
                root2 = root2.left;
            }

            if (stk2.isEmpty() || (!stk1.isEmpty() && stk1.peek().val <= stk2.peek().val)) {
                root1 = stk1.pop();
                ans.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stk2.pop();
                ans.add(root2.val);
                root2 = root2.right;
            }
        }
        return ans;
    }
}
