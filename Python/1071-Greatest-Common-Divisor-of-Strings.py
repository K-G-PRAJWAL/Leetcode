class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        n1 = len(str1)
        n2 = len(str2)

        def check_divisor(n):
            if n1 % n or n2 % n:
                return False

            x1, x2 = n1//n, n2//n
            s = str1[:n]

            return s*x1 == str1 and s*x2 == str2

        for i in range(min(n1, n2), 0, -1):
            if check_divisor(i):
                return str1[:i]

        return ""
