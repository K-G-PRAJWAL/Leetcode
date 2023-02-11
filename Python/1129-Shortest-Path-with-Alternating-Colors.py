class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        red = collections.defaultdict(list)
        blue = collections.defaultdict(list)

        for src, dest in redEdges:
            red[src].append(dest)

        for src, dest in blueEdges:
            blue[src].append(dest)

        ans = [-1 for i in range(n)]
        ans[0] = 0
        q = deque()
        q.append([0, 0, None])  # Node, distance, color to get there
        visited = set()
        visited.add((0, None))  # None, color to visit it

        while q:
            node, dist, prev_edge_color = q.popleft()
            if ans[node] == -1:
                ans[node] = dist

            if prev_edge_color != 'RED':
                for neighbor in red[node]:
                    if (neighbor, 'RED') not in visited:
                        visited.add((neighbor, 'RED'))
                        q.append([neighbor, dist+1, 'RED'])

            if prev_edge_color != 'BLUE':
                for neighbor in blue[node]:
                    if (neighbor, 'BLUE') not in visited:
                        visited.add((neighbor, 'BLUE'))
                        q.append([neighbor, dist+1, 'BLUE'])

        return ans
