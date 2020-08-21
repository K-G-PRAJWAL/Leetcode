class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        x, y = len(num1), len(num2)
        ans = [0]*(x+y)
        for i in range(x-1, -1, -1):
            for j in range(y-1, -1, -1):
                prod = (ord(num1[i]) - ord('0'))*(ord(num2[j]) - ord('0'))
                l, h = i+j+1, i+j
                prod += ans[l]
                ans[l] = prod % 10
                ans[h] += prod//10
        res = []
        for a in ans:
            if len(res) != 0 or a != 0:
                res.append(a)
        return "0" if len(res) == 0 else ''.join(str(ch) for ch in res)


s = Solution()
print(s.multiply("20", "3"))
