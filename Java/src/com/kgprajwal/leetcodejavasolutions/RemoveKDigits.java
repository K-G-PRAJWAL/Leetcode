package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) return "0";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i < n) {
            while (k > 0 && !stk.isEmpty() && stk.peek() > num.charAt(i)) {
                stk.pop();
                k--;
            }
            stk.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stk.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty()) ans.append(stk.pop());
        ans.reverse();
        while (ans.length() > 1 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        return ans.toString();
    }
}
