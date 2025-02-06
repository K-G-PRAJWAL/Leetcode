class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        freq = {}
        ans = 0

        for i in range(n):
            for j in range(i+1, n):
                x = nums[i] * nums[j]
                ans += freq.get(x, 0)
                freq[x] = freq.get(x, 0) + 1

        return ans * 8