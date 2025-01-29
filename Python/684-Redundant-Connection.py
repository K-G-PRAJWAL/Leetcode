class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1]*n

    def find(self, x):
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, u, v):
        pu, pv = self.find(u), self.find(v)
        print(pu, pv)
        if pu == pv:
            return False
        if self.size[pu] > self.size[pv]:
            self.size[pu] += self.size[pv]
            self.parent[pv] = pu
        else:
            self.size[pv] += self.size[pu]
            self.parent[pu] = pv

        return True

class Solution:
    def findRedundantConnection_UnionFind(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)

        u_f = UnionFind(n)

        for u, v in edges:
            if not u_f.union(u-1, v-1):
                return [u, v]

    # DFS
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)

        adj_list = [[] for _ in range(len(edges)+1)]

        def dfs(u, v, parent):
            if u == v:
                return True
            for neighbor in adj_list[u]:
                if neighbor == parent:
                    continue
                if dfs(neighbor, v, u):
                    return True
            return False

        for u, v in edges:
            if dfs(u, v, 0):
                return [u, v]
            else:
                adj_list[u].append(v)
                adj_list[v].append(u)