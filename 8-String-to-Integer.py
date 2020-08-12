class Solution:
    def myAtoi(self, s):
        maxii = 2147483647
        minii = -2147483648
        s = s.strip()
        if not s:
            return 0
        sign, idx = 1, 0
        if s[idx] == '+':
            idx += 1
        elif s[idx] == '-':
            sign = -1
            idx += 1
        num = 0
        n = len(s)
        while idx < n:
            if not s[idx].isdigit():
                break
            num = num*10 + ord(s[idx])-ord('0')
            if num > maxii:
                break
            idx += 1
        return min(max(sign*num, minii), maxii)


s = Solution()
print(s.myAtoi('         -41'))
