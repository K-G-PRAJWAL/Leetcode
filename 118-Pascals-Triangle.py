# Iterative I - Time: 94.24% | Space: 86.66%
class Solution:
    def generate(self, n):
        ans = [[1]*(i+1) for i in range(n)]
        for i in range(2, n):
            for j in range(1, i):
                ans[i][j] = ans[i-1][j-1]+ans[i-1][j]
        return ans


# Iterative II - Time: 62.14% | Space: 21.21%
class Solution:
    def generate(self, n):
        ans = []
        curr = [1]
        for i in range(n):
            ans.append(curr)
            curr = [1]+[curr[j]+curr[j+1] for j in range(len(curr)-1)]+[1]
        return ans


# Recursive - Time: 62.14% | Space: 43.67%
class Solution:
    def generate(self, n):
        ans = []
        self.helper(ans, n)
        return ans

    def helper(self, ans, n):
        if n == 1:
            ans.append([1])
        elif n > 1:
            self.helper(ans, n-1)
            prev = ans[n-2]
            curr = []
            for i in range(len(prev)):
                if i == 0:
                    curr.append(1)
                if i > 0:
                    curr.append(prev[i]+prev[i-1])
                if i == len(prev)-1:
                    curr.append(1)
            ans.append(curr)


s = Solution()
print(s.generate(5))
