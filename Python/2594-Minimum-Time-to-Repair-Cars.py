class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        l, r = 1, ranks[0]*cars**2

        def helper(time):
            cnt = 0
            for r in ranks:
                cnt += int(sqrt(time / r))
            return cnt

        ans = -1
        while l <= r:
            m = (l+r)//2
            repaired = helper(m)
            if repaired >= cars:
                ans = m
                r = m-1
            else:
                l = m+1
        return ans
