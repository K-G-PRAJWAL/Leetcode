class Solution:
    def lengthOfLastWord(self, s):
        length = len(s)
        if length == 0:
            return 0
        ans = 0
        i = length-1
        while i >= 0 and s[i] == " ":
            i -= 1
        if i < 0:
            return 0
        while i >= 0 and s[i] != " ":
            ans += 1
            i -= 1
        return ans


s = Solution()
print(s.lengthOfLastWord("Hello World "))
