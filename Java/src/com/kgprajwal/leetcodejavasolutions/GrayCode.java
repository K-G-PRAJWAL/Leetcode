package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int len = ans.size();
            for (int j = len - 1; j >= 0; j--)
                ans.add(ans.get(j) | 1 << i);
        }
        return ans;
    }

    public static void main(String[] args) {
        GrayCode g = new GrayCode();
        System.out.println(g.grayCode(2));
    }
}
