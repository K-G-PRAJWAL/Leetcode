package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    private boolean check(int num) {
        for (char ch : String.valueOf(num).toCharArray()) {
            if (ch == '0' || (num % (ch - '0') > 0)) return false;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) ans.add(i);
        }
        return ans;
    }
}
