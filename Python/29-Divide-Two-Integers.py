class Solution:
    def divide(self, dend, dsor):
        if dend == -2147483648 and dsor == -1:
            return 2147483647
        dvd = abs(dend)
        dvs = abs(dsor)
        ans = 0
        for i in range(32, -1, -1):
            if (dvd >> i)-dvs >= 0:
                ans += 1 << i
                dvd -= dvs << i
        return ans if (dend > 0) == (dsor > 0) else - ans


s = Solution()
print(s.divide(10, 3))
