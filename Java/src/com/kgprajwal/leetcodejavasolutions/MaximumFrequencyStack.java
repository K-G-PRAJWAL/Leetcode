package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> stk;
    int max;

    public FreqStack() {
        freq = new HashMap<>();
        stk = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        int x = freq.getOrDefault(val, 0) + 1;
        freq.put(val, x);
        if (x > max)
            max = x;
        stk.computeIfAbsent(x, z -> new Stack<>()).push(val);
    }

    public int pop() {
        int x = stk.get(max).pop();
        freq.put(x, freq.get(x) - 1);
        if (stk.get(max).size() == 0) max--;
        return x;
    }
}
