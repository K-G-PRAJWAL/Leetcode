package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            double sum = 0;
            int cnt = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.remove();
                sum += curr.val;
                cnt++;
                if (curr.left != null) temp.add(curr.left);
                if (curr.right != null) temp.add(curr.right);
            }
            q = temp;
            ans.add(sum / cnt);
        }
        return ans;
    }
}
