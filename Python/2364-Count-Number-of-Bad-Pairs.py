class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = 0
        pairs = n * (n-1) // 2
        map = defaultdict(int)

        for i, n in enumerate(nums):
            x = i - n
            cnt += map[x]
            map[x] = map[x] + 1

        return pairs - cnt