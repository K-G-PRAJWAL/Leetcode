package com.kgprajwal.leetcodejavasolutions;

public class PermutationInString {
    /* All permutations
    boolean flag;

    private String swap(String s, int b, int e) {
        if (b == e) return s;
        String s1 = s.substring(0, b);
        String s2 = s.substring(b + 1, e);
        String s3 = s.substring(e + 1);
        return s1 + s.charAt(e) + s2 + s.charAt(b) + s3;
    }

    private void permute(String s1, String s2, int idx) {
        if (idx == s1.length()) {
            if (s2.contains(s1)) flag = true;
        } else {
            for (int i = idx; i < s1.length(); i++) {
                s1 = swap(s1, idx, i);
                permute(s1, s2, idx + 1);
            }
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        permute(s1, s2, 0);
        return flag;
    }
    */

    /* Sorting
    private String sort(String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        return new String(sorted);
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        s1 = sort(s1);
        for (int i = 0; i <= l2 - l1; i++) {
            if (s1.equals(sort(s2.substring(i, i + l1)))) return true;
        }
        return false;
    }
    */

    private boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;
        int[] s1Freq = new int[26];
        for (int i = 0; i < l1; i++) s1Freq[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= l2 - l1; i++) {
            int[] s2Freq = new int[26];
            for (int j = 0; j < l1; j++) {
                s2Freq[s2.charAt(i + j) - 'a']++;
            }
            if (check(s1Freq, s2Freq)) return true;
        }
        return false;
    }
}
