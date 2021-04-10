package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    int target;

    public List<String> findStrobogrammatic(int n) {
        target = n;
        return find(n);
    }

    List<String> find(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("1");
            res.add("0");
            res.add("8");
            return res;
        }
        List<String> prev = find(n - 2);
        for (String s : prev) {
            if (n != target) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }
}
