class Solution:
    def maxDistance(self, position, m):
        position.sort()
        l, r = 0, position[-1] - position[0]
        while l < r:
            mid = r-(r-l)//2
            if self.check(mid, position) >= m:
                l = mid
            else:
                r = mid-1
        return l

    def check(self, distance, position):
        ans = 1
        curr = position[0]
        for i in range(1, len(position)):
            if position[i] - curr >= distance:
                ans += 1
                curr = position[i]
        return ans


s = Solution()
print(s.maxDistance([1, 2, 3, 4, 7], 3))
