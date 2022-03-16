package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stk = new Stack<>();

        int idx = 0;
        for (int val : pushed) {
            stk.push(val);
            while (!stk.empty() && stk.peek() == popped[idx]) {
                stk.pop();
                idx++;
            }
        }
        return idx == n;
    }
}
