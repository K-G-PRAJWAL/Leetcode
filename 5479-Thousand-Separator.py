class Solution:
    def thousandSeparator(self, n: int) -> str:
        ans = []
        s = str(n)
        l = len(s)
        cnt = 0
        for i in range(l-1, -1, -1):
            ans.append(s[i])
            cnt += 1
            if cnt == 3:
                ans.append(".")
                cnt = 0
        if l % 3 == 0:
            ans.pop()
        ans = ans[::-1]
        return "".join(map(str, ans))


s = Solution()
print(s.thousandSeparator(1234))
