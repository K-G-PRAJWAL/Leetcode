import collections


class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        if n == 1:
            return 0

        map = collections.defaultdict(list)
        ans = 0

        for i in range(n):
            map[arr[i]].append(i)

        visited = set()
        q = collections.deque([(0, 0)])

        while q:
            idx, ans = q.popleft()

            if idx == n-1:
                return ans

            for neighbor in map[arr[idx]]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    q.append((neighbor, ans+1))

            map[arr[idx]] = []

            if idx+1 not in visited and idx+1 <= n:
                visited.add(idx+1)
                q.append((idx+1, ans+1))

            if idx - 1 not in visited and idx-1 >= 0:
                visited.add(idx-1)
                q.append((idx-1, ans+1))
