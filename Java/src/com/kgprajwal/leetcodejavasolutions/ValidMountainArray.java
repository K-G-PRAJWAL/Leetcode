package com.kgprajwal.leetcodejavasolutions;

public class ValidMountainArray {
    /*public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1] && i < n - 2) {
                continue;
            } else {
                for (int j = i; j < n - 1; j++) {
                    if (arr[j] > arr[j + 1] && i > 0) {
                        continue;
                    } else return false;
                }
                break;
            }
        }
        return true;
    }*/

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1])
            i++;
        if (i == 0 || i == n - 1) return false;
        while (i + 1 < n && arr[i] > arr[i + 1]) i++;
        return i == n - 1;
    }
}
