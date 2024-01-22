class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)

        s = set(nums)
        actual = n*(n+1)//2 - sum(s)

        repeat = actual + sum(nums) - n*(n+1)//2

        return [repeat, actual]
