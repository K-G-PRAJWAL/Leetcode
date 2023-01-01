class Solution:
    '''
    https://leetcode.com/problems/word-pattern/
    '''

    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        map = {}
        if len(words) != len(pattern) or len(set(pattern)) != len(set(words)):
            return False

        for idx, ch in enumerate(pattern):
            if ch in map:
                if map[ch] != words[idx]:
                    return False
            else:
                map[ch] = words[idx]
        return True


s = Solution()
print(s.wordPattern("abba", "dog cat cat dog"))
print(s.wordPattern("abba", "dog cat cat fish"))
print(s.wordPattern("abba", "dog dog dog dog"))
print(s.wordPattern("abc", "b c a"))
