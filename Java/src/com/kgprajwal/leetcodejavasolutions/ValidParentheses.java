package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

// O(N)
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stk.push(ch);
            else if (ch == ')' && !stk.isEmpty() && stk.peek() == '(')
                stk.pop();
            else if (ch == '}' && !stk.isEmpty() && stk.peek() == '{')
                stk.pop();
            else if (ch == ']' && !stk.isEmpty() && stk.peek() == '[')
                stk.pop();
            else
                return false;
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
