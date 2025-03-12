class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)

        # pos = 0
        # neg = 0

        # for n in nums:
        #     if n > 0:
        #         pos += 1
        #     elif n < 0:
        #         neg += 1

        # return max(pos, neg)

        def upper(nums):
            l, r = 0, len(nums)-1
            i = len(nums)
            while l <= r:
                mid = (l+r)//2
                if nums[mid]<=0:
                    l = mid+1
                else:
                    r = mid-1
                    i = mid
            return i

        def lower(nums):
            l, r = 0, len(nums)-1
            i = len(nums)
            while l <= r:
                mid = (l+r)//2
                if nums[mid]<0:
                    l=mid+1
                else:
                    r=mid-1
                    i = mid
            return i

        pos = n - upper(nums)
        neg = lower(nums)

        return max(pos, neg)