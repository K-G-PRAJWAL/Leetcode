package com.kgprajwal.leetcodejavasolutions;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        /* Method 1
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i: nums) {
            if(map.get(i)==1) return i;
        }
        return 0;*/

        // Method 2
        int setSum = 0;
        int numSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                setSum += i;
            }
            numSum += i;
        }
        return 2 * setSum - numSum;
    }

    public static void main(String[] args) {
        SingleNumber o = new SingleNumber();
        System.out.println(o.singleNumber(new int[]{2, 2, 1}));
    }
}
