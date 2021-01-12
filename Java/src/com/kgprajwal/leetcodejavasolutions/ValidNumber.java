package com.kgprajwal.leetcodejavasolutions;

public class ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        boolean isDecimal = false;
        boolean isE = false;
        boolean isNum = false;
        boolean isNumberAfterE = false;
        for(int i=0;i<s.length();i++) {
            if('0'<=s.charAt(i) && s.charAt(i)<='9') {
                isNum = true;
                if(isE) isNumberAfterE = true;
            }
            else if(s.charAt(i)=='.') {
                if(isE || isDecimal) return false;
                isDecimal = true;
            }
            else if(s.charAt(i)=='e') {
                if(isE || !isNum) return false;
                isE = true;
                isNumberAfterE = false;
            }
            else if(s.charAt(i)=='-' || s.charAt(i)=='+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
        }
        return isNum && (isE && isNumberAfterE || !isE && !isNumberAfterE);
    }

    public static void main(String[] args) {
        System.out.println(isNumber("53.5e93"));
    }
}
