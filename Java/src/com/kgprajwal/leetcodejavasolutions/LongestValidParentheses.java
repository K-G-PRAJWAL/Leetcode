package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class LongestValidParentheses {
    // O(N)
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0;
        int maximum = 0;
        int l = s.length();
        for(int i=0;i<l;i++) {
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) maximum = Math.max(maximum, right*2);
            else if(right>=left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(int i=l-1;i>=0;i--) {
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) maximum = Math.max(maximum, left*2);
            else if(left>=right) {
                left = 0;
                right = 0;
            }
        }
        return maximum;
    }

    public static int longestValidParenthesesAlternative(String s) {
        int maximum = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') stk.push(i);
            else {
                stk.pop();
                if(stk.isEmpty()) stk.push(i);
                else maximum = Math.max(maximum, i-stk.peek());
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        String s = "()())";
        System.out.println(longestValidParentheses(s));
    }
}
