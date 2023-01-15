class Solution:
    def find(self, x, root):
        if x == root[x]:
            return x
        else:
            root[x] = self.find(root[x], root)
            return root[x]

    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        n = len(vals)
        ans = n  # No of nodes
        edges.sort(key=lambda x: max(vals[x[0]], vals[x[1]]))

        freq = [1]*n
        root = [_ for _ in range(n)]

        for u, v in edges:
            u = self.find(u, root)
            v = self.find(v, root)

            if vals[u] == vals[v]:
                ans += freq[u] * freq[v]
                root[u] = v
                freq[v] += freq[u]
            elif vals[u] > vals[v]:
                root[v] = u
            else:
                root[u] = v

        return ans
