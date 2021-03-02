package com.kgprajwal.leetcodejavasolutions;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        else return convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }
}
