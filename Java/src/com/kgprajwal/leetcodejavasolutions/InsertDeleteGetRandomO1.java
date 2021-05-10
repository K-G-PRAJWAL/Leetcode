package com.kgprajwal.leetcodejavasolutions;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    Random random;
    Map<Integer, Integer> map;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        return map.put(val, list.size() - 1) == null;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer position = map.get(val);
        Collections.swap(list, position, list.size() - 1);
        map.put(list.get(position), position);
        list.remove(list.size() - 1);
        return map.remove(val) != null;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
