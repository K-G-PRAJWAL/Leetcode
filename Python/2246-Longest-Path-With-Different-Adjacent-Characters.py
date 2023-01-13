 class Solution:
      ans = 0

       def longestPath(self, parent: List[int], s: str) -> int:
            graph = defaultdict(list)
            n = len(parent)

            for i in range(1, n):
                graph[parent[i]].append(i)
                graph[i].append(parent[i])

            self.dfs(graph, s, 0, -1)
            return self.ans

        def dfs(self, graph, s, node, prev):
            if node == None:
                return 0

            f_max = 0
            s_max = 0

            for child in graph[node]:
                if child != prev:
                    child_len = self.dfs(graph, s, child, node)
                    if s[child] != s[node]:
                        if child_len > f_max:
                            s_max = f_max
                            f_max = child_len
                        elif child_len > s_max:
                            s_max = child_len

            self.ans = max(self.ans, f_max + s_max + 1)
            return f_max + 1
