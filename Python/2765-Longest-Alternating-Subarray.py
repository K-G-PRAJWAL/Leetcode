class Solution:
    # [2,3,4,3,4]
    def alternatingSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        [curr, check] = [1, 1]
        maxi = -1

        for i in range(1, n):
            if nums[i] - nums[i-1] == check:
                curr += 1
                check = -check
                maxi = max(maxi, curr)
            elif nums[i] - nums[i-1]==1:
                [curr, check] = [2, -1]
            else:
                [curr, check] = [1, 1]
        
        return maxi