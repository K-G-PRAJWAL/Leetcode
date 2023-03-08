class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = max(piles)

        def check_speed(speed):
            time = 0
            for pile in piles:
                time += (pile+speed-1) // speed
            return time <= h

        while l < r:
            m = (l+r)//2
            if check_speed(m):
                r = m
            else:
                l = m+1
        return l
