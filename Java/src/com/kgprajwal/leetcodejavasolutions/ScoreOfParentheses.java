package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') stk.push(0);
            else {
                int x = stk.pop();
                int y = stk.pop();
                stk.push(y + Math.max(2 * x, 1));
            }
        }
        return stk.pop();
    }
}
