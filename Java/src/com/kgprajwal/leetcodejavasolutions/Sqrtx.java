package com.kgprajwal.leetcodejavasolutions;

public class Sqrtx {
//    public static int mySqrt(int x) {
//        long ans = x;
//        while (ans*ans > x) {
//            ans = (ans+x/ans)/2;
//        }
//        return (int)ans;
//    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        long start = 0;
        long end = x;
        while (start+1 < end) {
            long mid = start + (end - start) / 2;
            if(mid*mid==x) return (int)mid;
            else if(mid*mid<x) start = mid;
            else end = mid;
        }
        if(end*end==x) return (int)end;
        return (int)start;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
}
