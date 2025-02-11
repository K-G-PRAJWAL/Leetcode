class Solution:
    # O(n^2/m)
    def removeOccurrences(self, s: str, part: str) -> str:
        n = len(s)
        part_n = len(part)

        while s.count(part):
            idx = s.find(part)
            s = s[:idx]+s[idx+part_n:]

        return s

    # O(m*n)
    def removeOccurrences(self, s: str, part: str) -> str:
        n = len(s)
        part_n = len(part)

        stack = []

        def check(stack):
            return "".join(stack[-part_n:]) == part

        for ch in s:
            stack.append(ch)

            if len(stack) >= part_n and check(stack):
                for _ in range(part_n):
                    stack.pop()

        return "".join(stack)

    # O(M+N)
    def removeOccurrences(self, s: str, part: str) -> str:
        lps = [0]
        k = 0
        for i in range(1, len(part)):
            while k and part[k] != part[i]:
                k = lps[k-1]
            if part[k] == part[i]:
                k += 1
            lps.append(k)

        stack = [("", 0)]
        for ch in s:
            k = stack[-1][1]
            while k and part[k] != ch:
                k = lps[k-1]
            if part[k] == ch:
                k += 1
            stack.append((ch, k))
            if k == len(part):
                for _ in range(len(part)):
                    stack.pop()

        return "".join(x for x, _ in stack)