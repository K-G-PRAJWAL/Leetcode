class Solution:
    def getRow(self, rowIndex):
        # Solution 1 (Faster)
        ans = [1]*(rowIndex+1)
        for i in range(2, rowIndex+1):
            for j in range(i-1, 0, -1):
                ans[j] += ans[j-1]
        return ans

        # Solution 2
        init = 1
        ans = [init]
        for i in range(rowIndex):
            init = init*(rowIndex-i) // (i+1)
            ans.append(init)
        return ans


s = Solution()
print(s.getRow(3))
