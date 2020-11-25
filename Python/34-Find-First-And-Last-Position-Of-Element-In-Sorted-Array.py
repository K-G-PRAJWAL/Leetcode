class Solution:
    def searchRange(self, nums, target):
        l, r = self.lefty(nums, target), self.righty(nums, target)
        return [l, r] if l <= r else [-1, -1]

    def lefty(self, nums, target):
        n = len(nums)
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            if target > nums[mid]:
                l = mid+1
            else:
                r = mid-1
        return l

    def righty(self, nums, target):
        n = len(nums)
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            if target >= nums[mid]:
                l = mid+1
            else:
                r = mid-1
        return r


s = Solution()
print(s.searchRange([5, 7, 7, 8, 8, 10], 8))
