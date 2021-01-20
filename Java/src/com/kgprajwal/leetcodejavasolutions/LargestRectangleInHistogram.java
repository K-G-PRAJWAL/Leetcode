package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n ? 0 : heights[i]);
            if (stack.isEmpty() || currHeight >= heights[stack.peek()]) stack.push(i);
            else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
