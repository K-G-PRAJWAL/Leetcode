package com.kgprajwal.leetcodejavasolutions;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int[] x : points) {
            for (int[] y : points) {
                for (int[] z : points) {
                    area = Math.max(area, 0.5 * Math.abs(x[0] * y[1] + y[0] * z[1] + z[0] * x[1] - y[0] * x[1] - z[0] * y[1] - x[0] * z[1]));
                }
            }
        }
        return area;
    }
}
