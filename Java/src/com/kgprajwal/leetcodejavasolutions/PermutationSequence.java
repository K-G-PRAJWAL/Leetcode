package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int[] factArray = new int[n+1];
        Arrays.fill(factArray, 1);
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            factArray[i] = factArray[i-1]*i;
            arr.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0, j = k-1;i<n;i++) {
            int idx = j/factArray[n-1-i];
            sb.append(arr.remove(idx));
            j = j-idx*factArray[n-1-i];
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
