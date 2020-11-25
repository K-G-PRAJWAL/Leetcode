class Solution:
    def maxProduct(self, a):
        currMax = a[0]
        currMin = a[0]
        prevMax = a[0]
        prevMin = a[0]
        ans = a[0]
        for i in range(1, len(a)):
            currMax = max(prevMax*a[i], prevMin*a[i], a[i])
            currMin = min(prevMax*a[i], prevMin*a[i], a[i])
            ans = max(ans, currMax)
            prevMax = currMax
            prevMin = currMin
        return ans


s = Solution()
print(s.maxProduct([2, 3, -2, 4]))
