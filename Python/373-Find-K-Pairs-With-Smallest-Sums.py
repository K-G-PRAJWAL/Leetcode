import heapq


class Solution:
    def kSmallestPairs(self, nums1, nums2, k):
        a, b = len(nums1), len(nums2)
        ans = []
        if a*b > 0:
            q = [(nums1[0] + nums2[0], (0, 0))]
            visited = {}
            while len(ans) < k and q:
                x, (i, j) = heapq.heappop(q)
                ans.append((nums1[i], nums2[j]))
                if j+1 < b and (i, j+1) not in visited:
                    heapq.heappush(q, (nums1[i]+nums2[j+1], (i, j+1)))
                    visited[(i, j+1)] = 1
                if i+1 < a and (i+1, j) not in visited:
                    heapq.heappush(q, (nums1[i+1]+nums2[j], (i+1, j)))
                    visited[(i+1, j)] = 1
        return ans


s = Solution()
print(s.kSmallestPairs([1, 7, 11], [1, 2, 3], 3))
