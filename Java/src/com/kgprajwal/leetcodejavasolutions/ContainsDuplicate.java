package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> x = new HashSet<>(nums.length);
        for (int i : nums) {
            if (x.contains(i)) return true;
            x.add(i);
        }
        return false;
    }
}
