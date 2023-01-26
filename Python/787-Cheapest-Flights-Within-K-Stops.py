class Solution:
    # BFS
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)

        for from_node, to_node, price in flights:
            graph[from_node].append((to_node, price))

        q = deque()
        q.append((src, 0))

        ans = [float("inf")]*n

        while q and k >= 0:
            neighbors = len(q)
            for neighbor in range(neighbors):
                curr_node, curr_price = q.popleft()
                for next_node, next_price in graph[curr_node]:
                    if curr_price+next_price < ans[next_node]:
                        ans[next_node] = curr_price+next_price
                        q.append((next_node, ans[next_node]))
            k -= 1

        if ans[dst] == float('inf'):
            return -1
        else:
            return ans[dst]
