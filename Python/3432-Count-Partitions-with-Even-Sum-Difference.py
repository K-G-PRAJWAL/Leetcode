class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        n = len(nums)
        total = sum(nums)

        ans = 0
        curr = 0

        for i in range(n-1):
            curr += nums[i]
            total -= nums[i]

            if (curr - total)%2==0:
                ans += 1

        return ans