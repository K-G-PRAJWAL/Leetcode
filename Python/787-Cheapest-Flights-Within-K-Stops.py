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

    # Bellman-Ford
    def findCheapestPrice_2(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float('inf')]*n
        prices[src] = 0

        while k >= 0:
            tmp_prices = prices.copy()
            for from_node, to_node, price in flights:
                if prices[from_node] == float("inf"):
                    continue
                if prices[from_node] + price < tmp_prices[to_node]:
                    tmp_prices[to_node] = prices[from_node]+price
            prices = tmp_prices
            k -= 1
        return -1 if prices[to_node] == float('inf') else prices[to_node]
