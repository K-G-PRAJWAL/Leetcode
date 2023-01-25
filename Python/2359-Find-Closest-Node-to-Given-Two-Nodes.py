import collections


class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        graph = collections.defaultdict(list)

        for node, target in enumerate(edges):
            graph[node].append(target)

        node1_dist = {}
        node2_dist = {}

        def bfs(src, dist_map):
            q = deque()
            q.append([src, 0])  # 0 distance for the source node
            dist_map[src] = 0

            while q:
                node, dist = q.popleft()
                for neighbor in graph[node]:
                    if neighbor not in dist_map:
                        q.append([neighbor, dist+1])
                        dist_map[neighbor] = dist + 1

        bfs(node1, node1_dist)
        bfs(node2, node2_dist)

        ans = -1

        ans_dist = float("inf")
        for node in range(len(edges)):
            if node in node1_dist and node in node2_dist:
                dist = max(node1_dist[node], node2_dist[node])
                if dist < ans_dist:
                    ans = node
                    ans_dist = dist
        return ans
