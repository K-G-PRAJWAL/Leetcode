class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        def check(m):
            arr = [0] * (n + 1)
            for i in range(m):
                start, end, val = queries[i]
                arr[start] += val
                arr[end + 1] -= val
            cur = 0
            for i in range(n):
                cur += arr[i]
                if cur < nums[i]: return False
            return True

        if not check(len(queries)): return -1

        l, r = 0, len(queries)
        while l <= r:
            m = l + (r - l) // 2
            if check(m):
                r = m - 1
            else:
                l = m + 1
        return l