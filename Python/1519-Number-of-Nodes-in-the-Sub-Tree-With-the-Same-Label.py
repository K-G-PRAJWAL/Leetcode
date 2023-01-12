class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        def dfs(node, parent):
            prev = cnt[labels[node]]
            cnt[labels[node]] += 1

            for child in graph.get(node, []):
                if child != parent:
                    dfs(child, node)
            ans[node] = cnt[labels[node]] - prev

        graph = defaultdict(list)
        ans = [0] * n

        for u, v in edges:
            graph[u] += [v]
            graph[v] += [u]

        cnt = Counter()
        dfs(0, -1)

        return ans
