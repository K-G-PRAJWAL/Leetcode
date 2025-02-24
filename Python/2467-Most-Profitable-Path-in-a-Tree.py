class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        n = len(edges)+1
        adj = [[] for _ in range(n)]
        parent = [-1]*n
        Bob = [float('inf')]*n

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        def dfs(node, p):
            parent[node] = p
            for neigh in adj[node]:
                if neigh == p: continue
                dfs(neigh, node)

        dfs(0, -1)

        x = bob
        move = 0
        while x != -1:
            Bob[x] = move
            move += 1
            x = parent[x]

        def dfs_sum(i, dist, prev):
            alice = 0
            if dist < Bob[i]:
                alice = amount[i]
            elif dist == Bob[i]:
                alice = amount[i]//2
            isLeaf = True
            maxLeafSum =- float('inf')

            for j in adj[i]:
                if j == prev: continue
                isLeaf=False
                maxLeafSum = max(maxLeafSum, dfs_sum(j, dist+1, i))

            return alice if isLeaf else alice + maxLeafSum

        return dfs_sum(0, 0, -1)
