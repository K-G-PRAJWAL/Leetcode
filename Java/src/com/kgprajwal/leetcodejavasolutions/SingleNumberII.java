package com.kgprajwal.leetcodejavasolutions;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i : nums) {
            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        SingleNumberII o = new SingleNumberII();
        System.out.println(o.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
