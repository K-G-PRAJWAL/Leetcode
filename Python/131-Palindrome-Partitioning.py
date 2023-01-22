class Solution:
    # Solution 1
    def check_palindrome(self, s, i, j):
        while i < j:
            if s[i] != s[j]:
                return False
            j -= 1
            i += 1
        return True

    def backtrack(self, s, ans, idx, temp):
        if idx >= len(s):
            ans.append(temp.copy())
            return
        for j in range(idx, len(s)):
            if self.check_palindrome(s, idx, j):
                temp.append(s[idx:j+1])
                self.backtrack(s, ans, j+1, temp)
                temp.pop()

    def partition(self, s: str) -> List[List[str]]:
        ans = []
        self.backtrack(s, ans, 0, [])
        return ans
