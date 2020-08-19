class Solution:
    def search(self, nums, target):
        # Solution 1 - Iterative
        n = len(nums)
        l, r = 0, n-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[l]:
                if target <= nums[mid] and target >= nums[l]:
                    r = mid-1
                else:
                    l = mid+1
            else:
                if target >= nums[mid] and target <= nums[r]:
                    l = mid+1
                else:
                    r = mid-1
        return -1

        # Solution 2 - Recursive
        if not nums:
            return -1
        return self.BSHelper(nums, target, 0, len(nums)-1)

    def BSHelper(self, nums, target, l, r):
        if r < l:
            return -1
        mid = (l+r)//2
        if nums[mid] == target:
            return mid
        if nums[l] <= target < nums[mid]:
            return self.BSHelper(nums, target, l, mid-1)
        elif nums[mid] < target <= nums[r]:
            return self.BSHelper(nums, target, mid+1, r)
        elif nums[mid] > nums[r]:
            return self.BSHelper(nums, target, mid+1, r)
        else:
            return self.BSHelper(nums, target, l, mid-1)


s = Solution()
print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
