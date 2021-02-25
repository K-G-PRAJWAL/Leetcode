package com.kgprajwal.leetcodejavasolutions;

public class ReadNCharactersGivenRead4II {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;

    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (readBytes < n && !eof) {
            if (bufsize == 0) {
                bufsize = read4(buffer);
                eof = (bufsize < 4);
            }
            int bytes = Math.min(bufsize, n - readBytes);
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}
