class Solution:
    def generateParenthesis(self, n):
        self.n = n
        self.ans = []
        self.solve()
        return self.ans

    def solve(self, s='', l=0, r=0):
        if len(s) == 2 * self.n:
            self.ans.append(s)
            return
        if l < self.n:
            self.solve(s+'(', l+1, r)
        if r < l:
            self.solve(s + ')', l, r + 1)


s = Solution()
print(s.generateParenthesis(3))
