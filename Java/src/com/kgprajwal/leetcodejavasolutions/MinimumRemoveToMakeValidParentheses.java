package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        String[] arr = s.split("");
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i])) stk.push(i);
            else if (")".equals(arr[i])) {
                if (!stk.empty()) stk.pop();
                else arr[i] = "";
            }
        }
        while (!stk.empty()) arr[stk.pop()] = "";
        return String.join("", arr);
    }
}
