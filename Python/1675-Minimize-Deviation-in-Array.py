import heapq


class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        min_heap = []
        heap_max = 0

        for n in nums:
            tmp = n
            while n % 2 == 0:
                n //= 2
            min_heap.append((n, max(tmp, 2*n)))
            heap_max = max(heap_max, n)

        ans = float("inf")
        heapq.heapify(min_heap)

        while len(min_heap) == len(nums):
            n, n_max = heapq.heappop(min_heap)
            ans = min(ans, heap_max-n)

            if n < n_max:
                heapq.heappush(min_heap, (n*2, n_max))
                heap_max = max(heap_max, n*2)

        return ans
