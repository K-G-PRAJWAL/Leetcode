package com.kgprajwal.leetcodejavasolutions;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int noOfPigs = 0;
        while(Math.pow(minutesToTest/minutesToDie+1, noOfPigs) < buckets) {
            noOfPigs += 1;
        }
        return noOfPigs;
    }
}
