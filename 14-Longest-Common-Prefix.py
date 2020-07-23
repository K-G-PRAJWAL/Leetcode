class Solution:
    def longestCommonPrefix(self, strs):
        LCP = ''
        if len(strs) == 0:
            return LCP
        else:
            x = 0
            for letter in strs[0]:
                for i in range(1, len(strs)):
                    if x >= len(strs[i]) or letter != strs[i][x]:
                        return LCP
                LCP += letter
                x += 1
            return LCP


s = Solution()
print(s.longestCommonPrefix(['samantha', 'samarth']))
