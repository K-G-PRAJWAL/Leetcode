class Solution:
    def calc(self, p1, p2):
        x1 = p1[0]
        x2 = p2[0]
        y1 = p1[1]
        y2 = p2[1]
        slope = 0

        if x1 == x2:
            slope = float('inf')
        elif y1 == y2:
            slope = 0
        else:
            slope = (y2-y1) / (x2-x1)

        return slope

    def maxPoints(self, points) -> int:
        n = len(points)
        if n == 1:
            return 1
        ans = 0
        for i in range(n):
            map = dict()
            for j in range(i+1, n):
                slope = self.calc(points[i], points[j])
                if slope in map:
                    map[slope] += 1
                else:
                    map[slope] = 1
                ans = max(ans, map[slope])

        return ans + 1


s = Solution()
print(s.maxPoints([[1, 1], [2, 2], [3, 3]]))
