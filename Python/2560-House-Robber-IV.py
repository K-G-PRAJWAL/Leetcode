class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        l, r = min(nums), max(nums)

        def is_valid(capability):
            i = 0
            cnt = 0
            while i < len(nums):
                if nums[i] <= capability:
                    i += 2
                    cnt += 1
                else:
                    i += 1
                if cnt == k:
                    break
            return cnt == k

        ans = 0
        while l<=r:
            m = (l+r)//2
            if is_valid(m):
                ans = m
                r = m-1
            else:
                l = m+1

        return ans