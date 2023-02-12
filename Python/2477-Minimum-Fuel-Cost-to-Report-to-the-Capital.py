class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        graph = collections.defaultdict(list)

        for src, dest in roads:
            graph[src].append(dest)
            graph[dest].append(src)

        ans = 0

        def dfs(node, parent):
            nonlocal ans
            passengers = 0

            for child in graph[node]:
                if child != parent:
                    curr_passengers = dfs(child, node)
                    passengers += curr_passengers
                    ans += int(ceil(curr_passengers/seats))
            return passengers + 1

        dfs(0, -1)
        return ans
