package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' ||
                    expression.charAt(i) == '*' ||
                    expression.charAt(i) == '+') {
                String a = expression.substring(0, i);
                String b = expression.substring(i + 1);
                List<Integer> x = diffWaysToCompute(a);
                List<Integer> y = diffWaysToCompute(b);
                for (Integer p1 : x) {
                    for (Integer p2 : y) {
                        int c = 0;
                        switch (expression.charAt(i)) {
                            case '+':
                                c = p1 + p2;
                                break;
                            case '-':
                                c = p1 - p2;
                                break;
                            case '*':
                                c = p1 * p2;
                                break;
                        }
                        ans.add(c);
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}
