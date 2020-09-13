import collections
import heapq


class Solution:
    def minCostConnectPoints(self, points):
        # n = len(points)
        # if n==1:
        #     return 0
        # ans = 0
        # curr = 0
        # dist = [float("inf")]*n
        # visited = set()
        # for i in range(n-1):
        #     x0, y0 = points[curr]
        #     visited.add(curr)
        #     for j, (x, y) in enumerate(points):
        #         if j in visited:
        #             continue
        #         dist[j] = min(dist[j], abs(x-x0)+abs(y-y0))
        #     change, curr = min((d, j) for j, d in enumerate(dist))
        #     dist[curr] = float("inf")
        #     ans+=change
        # return ans

        n = len(points)
        def cost(x, y): return abs(x[0]-y[0])+abs(x[1]-y[1])
        d = collections.defaultdict(list)
        for i in range(n):
            for j in range(i+1, n):
                dist = cost(points[i], points[j])
                d[i].append((dist, j))
                d[j].append((dist, i))
        ans = 0
        visited = [False]*n
        cnt = 1
        heap = d[0]
        visited[0] = True
        heapq.heapify(heap)
        while heap:
            dist, j = heapq.heappop(heap)
            if not visited[j]:
                visited[j] = True
                cnt += 1
                ans += dist
                for k in d[j]:
                    heapq.heappush(heap, k)
            if cnt >= n:
                break
        return ans


s = Solution()
print(s.minCostConnectPoints([[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]))
