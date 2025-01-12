class Solution:
    def minMaxWeight(self, n: int, edges: List[List[int]], threshold: int) -> int:
        graph = defaultdict(list)

        for i, j, w in edges:
            graph[j].append((i, w))

        max_weight = max([w for _, _, w in edges])

        def dfs(node, target_weight, visited):
            for dst, w in graph[node]:
                if w <= target_weight and dst not in visited:
                    visited.add(dst)
                    dfs(dst, target_weight, visited)

        l, r = 0, max_weight+1
        while l < r:
            mid = (l+r)//2
            visited = set([0])
            dfs(0, mid, visited)
            if len(visited) != n:
                l = mid+1
            else:
                r = mid

        return l if l != max_weight + 1 else -1