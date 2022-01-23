package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int digit = 1; digit <= 9; digit++) {
            int number = digit;
            for (int next = digit + 1; next <= 9; next++) {
                number = number * 10 + next;
                if (number >= low && number <= high) ans.add(number);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
