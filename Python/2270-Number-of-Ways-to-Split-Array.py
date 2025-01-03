class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        n = len(nums)
        pfx_sum = nums

        for i in range(1, n):
            pfx_sum[i] += pfx_sum[i-1]

        print(pfx_sum)
        ans = 0
        for i in range(n-1):
            if pfx_sum[i] >= pfx_sum[-1] - pfx_sum[i]:
                ans+=1

        return ans

    def waysToSplitArray_2(self, nums: List[int]) -> int:
        n = len(nums)

        l_sum = r_sum = 0
        r_sum = sum(nums)

        cnt = 0
        for i in range(n-1):
            l_sum += nums[i]
            r_sum -= nums[i]

            if l_sum >= r_sum:
                cnt += 1

        return cnt