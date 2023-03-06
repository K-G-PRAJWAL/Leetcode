class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        n = len(arr)
        l = 0
        r = n-1

        while l <= r:
            m = (l+r)//2
            missing = self.check(arr[m], m+1)
            if missing >= k:
                r = m-1
            else:
                l = m+1

        if r == -1:
            return k
        return arr[r]+k-self.check(arr[r], r+1)

    def check(self, actual, expected):
        return actual-expected
