package com.kgprajwal.leetcodejavasolutions;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        /*Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int idx = stk.pop();
                ans[idx] = i - idx;
            }
            stk.push(i);
        }
        return ans;*/
        // Alternate solution
        int n = temperatures.length;
        int[] stk = new int[n];
        int[] ans = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top > -1 && temperatures[i] > temperatures[stk[top]]) {
                int idx = stk[top--];
                ans[idx] = i - idx;
            }
            stk[++top] = i;
        }
        return ans;
    }
}
