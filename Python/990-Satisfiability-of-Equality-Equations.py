import collections


class Solution:
    # Union Find
    # def equationsPossible(self, equations):
    #     x = [0 for _ in range(26)]
    #     for i in range(26):
    #         x[i] = i
    #     for equation in equations:
    #         if equation[1] == '=':
    #             x[self.find(ord(equation[0])-ord('a'), x)
    #               ] = self.find(ord(equation[3]) - ord('a'), x)
    #     for equation in equations:
    #         if equation[1] == '!' and self.find(ord(equation[0]) - ord('a'), x) == self.find(ord(equation[3]) - ord('a'), x):
    #             print(x)
    #             return False
    #     return True

    # def find(self, c, x):
    #     if c != x[c]:
    #         x[c] = self.find(x[c], x)
    #     return x[c]

    # DFS
    def equationsPossible(self, equations):
        G = collections.defaultdict(set)
        notEq = []

        def dfs(u, target, visited):
            if u == target:
                return True
            visited.add(u)
            for v in G[u]:
                if v in visited:
                    continue
                if dfs(v, target, visited):
                    return True
            return False

        for equation in equations:
            if equation[1:3] == '!=':
                a, b = equation.split('!=')
                notEq.append((a, b))
                continue
            u, v = equation.split('==')
            G[u].add(v)
            G[v].add(u)
        for u, v in notEq:
            if dfs(u, v, set()):
                return False
        return True


s = Solution()
print(s.equationsPossible(['a==b', 'a!=b']))
print(s.equationsPossible(["a==b", "b!=c", "c==a"]))
