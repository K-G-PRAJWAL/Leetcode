class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)

        if m == 0:
            return 0

        for i in range(n+1-m):
            for j in range(n):
                if haystack[i+j] != needle[j]:
                    break
                if j == m-1:
                    return i

        return -1
