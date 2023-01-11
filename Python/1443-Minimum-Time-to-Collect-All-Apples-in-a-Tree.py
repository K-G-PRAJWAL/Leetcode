class Solution:
    def createGraph(self, edges):
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        return graph

    def dfs(self, graph, curr_node, prev_node, hasApple, curr_time):
        child_time = 0
        for neighbor in graph[curr_node]:
            if neighbor == prev_node:
                continue
            child_time += self.dfs(graph, neighbor, curr_node, hasApple, 2)

        if child_time == 0 and hasApple[curr_node] == False:
            return 0
        return curr_time + child_time

    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        graph = self.createGraph(edges)
        return self.dfs(graph, 0, None, hasApple, 0)
