package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    /*
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    ans[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return ans;
    }
    */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stk.empty() && nums[stk.peek()] < nums[i % n])
                ans[stk.pop()] = nums[i % n];
            stk.push(i % n);
        }
        return ans;
    }
}
