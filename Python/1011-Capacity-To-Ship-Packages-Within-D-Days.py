class Solution:
    def check_ship(self, weights, cap, days):
        ships = 1
        curr_cap = cap

        for w in weights:
            if curr_cap - w < 0:
                ships += 1
                curr_cap = cap
            curr_cap -= w

        return ships <= days

    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l = max(weights)
        r = sum(weights)
        ans = r

        while l <= r:
            m = (l+r)//2
            if self.check_ship(weights, m, days):
                ans = min(ans, m)
                r = m - 1
            else:
                l = m+1

        return ans
