class Solution:
    def lengthOfLongestSubstring(self, s):
        start, maxi = 0, 0
        used = {}
        for i, letter in enumerate(s):
            if letter in used and start <= used[letter]:
                start = used[letter] + 1
            else:
                maxi = max(maxi, i-start+1)
            used[letter] = i
        return maxi


s = Solution()
print(s.lengthOfLongestSubstring('abcabcbb'))
print(s.lengthOfLongestSubstring(' '))
