class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # Solution 1
        # n = len(s)
        # if numRows > n or numRows <= 1:
        #     return s
        # ans = ['']*n
        # cnt = 0
        # interval = 2*numRows - 2
        # for i in range(numRows):
        #     step = interval - 2*i
        #     for j in range(i, n, interval):
        #         ans[cnt] = s[j]
        #         cnt += 1
        #         if step > 0 and step < interval and j+step < n:
        #             ans[cnt] = s[j+step]
        #             cnt += 1
        # return "".join(ans)

        # Solution 2
        n = len(s)
        if n <= numRows or numRows == 1:
            return s
        ans = [[] for i in range(numRows)]
        idx = 0
        for letter in s:
            ans[idx].append(letter)
            if idx == 0:
                stp = 1
            if idx == numRows-1:
                stp = -1
            idx += stp
            print(ans, idx)
        return "".join(["".join(letter) for letter in ans])


s = Solution()
print(s.convert('PAYPALISHIRING', 3))
