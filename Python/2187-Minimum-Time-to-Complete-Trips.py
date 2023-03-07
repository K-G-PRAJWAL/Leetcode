class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        l, r = 1, 100000000000000

        while l <= r:
            min_time = 0
            m = l + (r - l) // 2

            for t in time:
                min_time += m // t

            if min_time >= totalTrips:
                r = m - 1
            else:
                l = m + 1
        return l
