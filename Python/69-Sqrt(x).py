class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        l, r = 1, x
        while l < r:
            mid = (l+r)//2
            if mid*mid == x:
                return mid
            elif mid*mid < x:
                l = mid+1
            elif mid*mid > x:
                r = mid
        return l-1


s = Solution()
print(s.mySqrt(8))
