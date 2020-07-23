class Solution:
    def reverse(self, x: int) -> int:
        num = 0
        flag = 0
        if x < 0:
            x = x*-1
            flag = 1
        while x > 0:
            rem = x % 10
            x = x//10
            num = num*10+rem
        if num > 2**31:
            return 0
        return -1*num if flag == 1 else num


s = Solution()
print(s.reverse(123))
