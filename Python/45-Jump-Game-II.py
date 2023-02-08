class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0

        l, r = 0, 0

        while r < n - 1:
            farthest = 0
            for i in range(l, r+1):
                farthest = max(farthest, nums[i]+i)
            l = r+1
            r = farthest
            ans += 1

        return ans
