package com.kgprajwal.leetcodejavasolutions;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int sqArea = (int) Math.sqrt(area);
        while (area % sqArea != 0) sqArea--;
        return new int[]{area / sqArea, sqArea};
    }
}
