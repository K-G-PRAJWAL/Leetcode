class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        n = len(nums)
        cntr = Counter(nums)

        def kadane(x):
            ans = curr = 0
            for n in nums:
                if n == k:
                    curr -= 1
                if n == x:
                    curr += 1
                if curr < 0:
                    curr = 0
                ans = max(ans, curr)

            return ans

        ans = max(kadane(n) for n in cntr)
        return cntr[k] + ans