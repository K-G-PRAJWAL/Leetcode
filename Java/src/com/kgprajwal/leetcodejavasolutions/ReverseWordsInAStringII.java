package com.kgprajwal.leetcodejavasolutions;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) return;
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
        i = 0;
        j = 0;
        while (j < s.length) {
            while (j < s.length && s[j] != ' ') {
                j++;
            }
            int m = i;
            int n = j - 1;
            while (m < n) {
                swap(s, m, n);
                m++;
                n--;
            }
            i = j + 1;
            j = i;
        }
    }


    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
