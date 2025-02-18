class Solution:
    # O(N) time and O(N) space
    def generate(self, idx, cnt, pattern):
        if idx != len(pattern):
            if pattern[idx]=='I':
                self.generate(idx+1, idx+1, pattern)
            else:
                cnt = self.generate(idx+1, cnt, pattern)
        self.ans.append(str(cnt+1))
        return cnt + 1

    def smallestNumber(self, pattern: str) -> str:
        n = len(pattern)
        self.ans = []
        self.generate(0, 0, pattern)
        return ''.join(self.ans[::-1])

    # O(n) time and space
    def smallestNumber(self, pattern: str) -> str:
        n = len(pattern)

        stack = []
        ans = []

        for i in range(n+1):
            stack.append(i+1)

            if i == n or pattern[i] == 'I':
                while stack:
                    ans.append(str(stack.pop()))

        return ''.join(ans)

    # O(N^2) Time and O(N) Space
    def smallestNumber(self, pattern: str) -> str:
        n = len(pattern)
        ans = []

        prev = 0
        for curr in range(n+1):
            ans.append(str(curr+1))

            if curr == n or pattern[curr] == 'I':
                ans[prev:] = reversed(ans[prev:])
                prev = curr + 1

        return ''.join(ans)