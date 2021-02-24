package com.kgprajwal.leetcodejavasolutions;

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        int bufferSize = 4;
        int numberOfCharsRead = 0;
        int bufferIndex = 0;
        char[] buffer = new char[bufferSize];
        while ((numberOfCharsRead = read4(buffer)) > 0 && n > 0) {
            int noOfChars = Math.min(numberOfCharsRead, bufferSize);
            for (int i = 0; i < Math.min(numberOfCharsRead, bufferSize) && n > 0; i++) {
                buf[bufferIndex++] = buffer[i];
                n--;
            }
        }
        return bufferIndex;
    }
}
