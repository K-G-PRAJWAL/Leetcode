package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> cntStk = new Stack<>();
        Stack<StringBuilder> ansStk = new Stack<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) i = i * 10 + ch - '0';
            else if (ch == '[') {
                cntStk.push(i);
                ansStk.push(ans);
                ans = new StringBuilder();
                i = 0;
            } else if (ch == ']') {
                StringBuilder tmp = ans;
                ans = ansStk.pop();
                for (i = cntStk.pop(); i > 0; i--) ans.append(tmp);
            } else ans.append(ch);
        }
        return ans.toString();
    }
}
