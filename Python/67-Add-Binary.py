class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = int(a, 2)
        b = int(b, 2)
        return "{0:b}".format(a+b)


s = Solution()
print(s.addBinary("11", "1"))
