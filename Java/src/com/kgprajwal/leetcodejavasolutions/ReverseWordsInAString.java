package com.kgprajwal.leetcodejavasolutions;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s.length() < 1) return s;
        int start = 0;
        char[] ch = s.toCharArray();
        reverse(ch, 0, ch.length - 1);
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                if (start != 0) ch[start++] = ' ';
                int j = i;
                while (j < ch.length && ch[j] != ' ') ch[start++] = ch[j++];
                reverse(ch, start - (j - i), start - 1);
                i = j;
            }
        }
        return new String(ch, 0, start);
    }

    void reverse(char[] ch, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString o = new ReverseWordsInAString();
        System.out.println(o.reverseWords("the sky is blue"));
    }
}
