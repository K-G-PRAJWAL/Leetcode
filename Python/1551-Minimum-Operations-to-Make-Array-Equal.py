class Solution:
    def minOperations(self, n):
        return (n//2)*((n+1)//2)


s = Solution()
print(s.minOperations(3))
print(s.minOperations(6))
