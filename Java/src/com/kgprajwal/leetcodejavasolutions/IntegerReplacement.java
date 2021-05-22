package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        return helper(new HashMap<>(), n);
    }

    int helper(Map<Long, Integer> dp, long curr) {
        if (curr == 1) return 0;
        if (dp.containsKey(curr)) return dp.get(curr);
        int ans = 0;
        if (curr % 2 == 0) {
            ans = 1 + helper(dp, curr / 2);
        } else {
            ans = 1 + Math.min(helper(dp, curr - 1), helper(dp, curr + 1));
        }
        dp.put(curr, ans);
        return ans;
    }
}
