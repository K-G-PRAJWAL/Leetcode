class Solution:
    def maxArea(self, height):
        i = 0
        j = len(height)-1
        totalWater = 0
        while i < j:
            totalWater = max(totalWater, (j-i)*min(height[i], height[j]))
            if height[i] == height[j]:
                i += 1
                j -= 1
            elif height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return totalWater


s = Solution()
print(s.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
