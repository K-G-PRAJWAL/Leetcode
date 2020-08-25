class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # Boyer's Moore Algorithm - 99.3%
        ans = nums[0]
        cnt = 1
        for val in nums[1:]:
            if val != ans:
                cnt -= 1
                if cnt == 0:
                    ans = val
                    cnt = 1
            else:
                cnt += 1
        return ans

        # Solution 2
        d = {}
        for val in nums:
            if val not in d:
                d[val] = 1
            if d[val] > len(nums)//2:
                return val
            else:
                d[val] += 1
