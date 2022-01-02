package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;

public class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long n = asteroids.length;
        long totalMass = mass;
        Arrays.sort(asteroids);
        for (int i = 0; i < n; i++) {
            if (totalMass >= asteroids[i]) {
                totalMass += asteroids[i];
            } else return false;
        }
        return true;
    }
}
