package com.kgprajwal.leetcodejavasolutions;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int tmp, cnt;
        if(Integer.MIN_VALUE==dividend && divisor==-1) return Integer.MAX_VALUE;
        int ans = 0;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        while(a-b >= 0) {
            tmp = b;
            cnt = 1;
            while(a-(tmp<<1) >= 0) {
                tmp<<=1;
                cnt<<=1;
            }
            a-=tmp;
            ans+=cnt;
        }
        return (dividend>0)==(divisor>0) ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
