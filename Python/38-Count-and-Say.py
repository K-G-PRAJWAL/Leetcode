class Solution:
    def nextNum(self, s):
        res = []
        i = 0
        while i < len(s):
            count = 1
            while i + 1 < len(s) and s[i] == s[i+1]:
                i += 1
                count += 1
            res.append(str(count) + s[i])
            i += 1
        return "".join(res)

    def countAndSay(self, n: int) -> str:
        s = "1"
        for i in range(n-1):
            s = self.nextNum(s)
        return s


s = Solution()
print(s.countAndSay(4))
