package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStructureDesign {
    Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        if (map.containsKey(number)) map.put(number, map.get(number) + 1);
        else map.put(number, 1);
    }

    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int target = value - key;
            if (map.containsKey(target)) {
                if (target == key && map.get(key) < 2) continue;
                return true;
            }
        }
        return false;
    }
}
