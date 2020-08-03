class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == "" or len(s) < 1:
            return ""
        start, end = 0, 0
        maxi = 0
        for i in range(len(s)):
            len1 = self.expand(s, i, i)
            len2 = self.expand(s, i, i+1)
            length = max(len1, len2)
            if length > end-start:
                start, end = i - ((length-1)//2), i + (length//2)
        return s[start:end+1]

    def expand(self, s, l, r):
        if s == "" or l > r:
            return 0
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1


s = Solution()
print(s.longestPalindrome("babad"))
