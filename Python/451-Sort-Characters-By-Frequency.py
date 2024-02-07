class Solution:
    def frequencySort(self, s: str) -> str:
        cnt = Counter(s)

        heap = [(-v, k) for k, v in cnt.items()]
        heapq.heapify(heap)

        ans = []
        while heap:
            v, k = heapq.heappop(heap)
            ans += [k]*-v

        return ''.join(ans)
