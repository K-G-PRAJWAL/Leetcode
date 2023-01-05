class Solution:
    def findMinArrowShots(self, points):
        points.sort(key=lambda x: x[1])
        currEnd = points[0][1]
        arrows = 1

        for start, end in points:
            if start > currEnd:
                arrows += 1
                currEnd = end

        return arrows


s = Solution()
print(s.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]]))
