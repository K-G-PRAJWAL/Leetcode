package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String ch : tokens) {
            if (ch.equals("+")) stk.add(stk.pop() + stk.pop());
            else if (ch.equals("/")) {
                int divisor = stk.pop();
                int dividend = stk.pop();
                stk.add(dividend / divisor);
            } else if (ch.equals("*")) stk.add(stk.pop() * stk.pop());
            else if (ch.equals("-")) {
                int b = stk.pop();
                int a = stk.pop();
                stk.add(a - b);
            } else stk.add(Integer.parseInt(ch));
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation o = new EvaluateReversePolishNotation();
        System.out.println(o.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
