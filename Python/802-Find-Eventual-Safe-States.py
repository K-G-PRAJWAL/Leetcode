class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:

        def dfs(node, graph, visited, stack):
            if stack[node]:
                return True
            if visited[node]:
                return False
            visited[node] = True
            stack[node] = True

            for neighbor in graph[node]:
                if dfs(neighbor, graph, visited, stack):
                    return True
            stack[node] = False
            return False


        n = len(graph)

        visited = [False]*n
        stack = [False]*n

        for i in range(n):
            dfs(i, graph, visited, stack)

        safe_nodes = []
        for i in range(n):
            if not stack[i]:
                safe_nodes.append(i)

        return safe_nodes