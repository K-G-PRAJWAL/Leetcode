import heapq
import random


class Solution:
    def findKthLargest(self, nums, k):
        # Solution 1: O(n) Time
        if not nums:
            return
        x = random.choice(nums)
        l, m, r = [i for i in nums if i > x], [
            i for i in nums if i == x], [i for i in nums if i < x]
        nums, i, j = l+m+r, len(l), len(l)+len(m)
        return self.findKthLargest(nums[:i], k) if k <= i else self.findKthLargest(nums[j:], k-j) if k > j else nums[i]

        # Solution 2: O(n log k) Time
        q = nums[:k]
        heapq.heapify(q)
        for i in nums[k:]:
            heapq.heappush(q, i)
            heapq.heappop(q)
        return q[0]


s = Solution()
print(s.findKthLargest([3, 2, 1, 5, 6, 4], 2))
