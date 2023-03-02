class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.merge_sort(nums)

    def merge_sort(self, nums):
        if len(nums) <= 1:
            return nums
        mid = len(nums)//2
        l = self.merge_sort(nums[:mid])
        r = self.merge_sort(nums[mid:])
        return self.merge(l, r)

    def merge(self, l, r):
        i = j = 0
        ans = []
        while i < len(l) and j < len(r):
            if l[i] <= r[j]:
                ans.append(l[i])
                i += 1
            else:
                ans.append(r[j])
                j += 1
        ans += l[i:]
        ans += r[j:]
        return ans
