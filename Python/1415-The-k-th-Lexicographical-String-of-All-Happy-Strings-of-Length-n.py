class Solution:
    def generate(self, n, curr, happy):
        if len(curr) == n:
            happy.append(curr)
            return
        for ch in ['a', 'b', 'c']:
            if len(curr) > 0 and curr[-1] == ch:
                continue
            self.generate(n, curr+ch, happy)

    def getHappyString(self, n: int, k: int) -> str:
        curr = ""
        happy = []

        self.generate(n, curr, happy)

        if len(happy) < k:
            return ""

        happy.sort()
        return happy[k-1]

    #### Stack Soln
    def getHappyString(self, n: int, k: int) -> str:
        stack = []
        idxs = 0

        stack.append("")

        while stack:
            curr = stack.pop()

            if len(curr) == n:
                idxs += 1
                if idxs == k:
                    return curr
                continue

            for ch in reversed(['a', 'b', 'c']):
                if len(curr) == 0 or curr[-1] != ch:
                    stack.append(curr+ch)

        return ""

    ### BFS
    def getHappyString(self, n: int, k: int) -> str:
        next = {'a': 'bc', 'b': 'ac', 'c': 'ab'}

        q = collections.deque(['a', 'b', 'c'])

        while len(q[0]) != n:
            u = q.popleft()
            for v in next[u[-1]]:
                q.append(u+v)

        return q[k-1] if len(q) >= k else ""

    #### O(N)
    def getHappyString(self, n: int, k: int) -> str:
        total = 3*2**(n-1)

        if k > total:
            return ""

        chars = set('abc')
        last = ''
        res = ['']*n

        for i in range(n):
            choice = sorted(chars - set(last))
            total //= len(choice)
            last = choice[(k-1)//total]
            res[i] = last
            k%=total

        return ''.join(res)