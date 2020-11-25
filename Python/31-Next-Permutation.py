class Solution:
    def nextPermutation(self, nums):
        # Solution 1 - Binary (Faster)
        #         n = len(nums)
        #         i = n-1
        #         while i>0 and nums[i-1]>=nums[i]:
        #             i-=1
        #         if i>0:
        #             l, r = i, n-1
        #             while l<=r:
        #                 mid = (l+r)//2
        #                 if nums[i-1]<nums[mid]:
        #                     l=mid+1
        #                 else:
        #                     r=mid-1
        #             nums[i-1], nums[l-1] = nums[l-1], nums[i-1]
        #         l, r = i, n-1
        #         while l<r:
        #             nums[l],nums[r] = nums[r], nums[l]
        #             l+=1
        #             r-=1

        # Solution 2 - Linear
        i = len(nums)-1
        k = i
        while i > 0 and nums[i-1] >= nums[i]:
            i -= 1
        j = i
        while j < k:
            nums[j], nums[k] = nums[k], nums[j]
            j += 1
            k -= 1
        if i > 0:
            i -= 1
            k = i
            while nums[k] <= nums[i]:
                k += 1
            nums[i], nums[k] = nums[k], nums[i]


s = Solution()
print(s.nextPermutation([1, 2, 3]))
print(s.nextPermutation([3, 2, 1]))
print(s.nextPermutation([6, 2, 1, 5, 4, 3, 0]))
