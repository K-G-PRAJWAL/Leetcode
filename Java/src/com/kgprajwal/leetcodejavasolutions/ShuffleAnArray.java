package com.kgprajwal.leetcodejavasolutions;

import java.util.Random;

public class ShuffleAnArray {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, random(i, array.length));
        }
        return array;
    }

    int random(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
