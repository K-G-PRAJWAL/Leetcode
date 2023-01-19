class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        map = defaultdict(int)
        map[0] = 1
        sum = 0
        ans = 0

        for i in range(len(nums)):
            sum += nums[i]
            remainder = sum % k

            ans += map[remainder]
            map[remainder] += 1

        return ans
