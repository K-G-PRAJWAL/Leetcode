class Solution:
    # Solution 1 - DFS+Backtracking
    def permuteUnique(self, nums):
        ans = []
        nums.sort()
        if not nums:
            return []
        else:
            self.helper(nums, [], ans)
            return ans

    def helper(self, nums, path, ans):
        if not nums:
            ans.append(path)
        else:
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                self.helper(nums[:i] + nums[i + 1:], path + [nums[i]], ans)

    # Solution 2 - Iterative
    def permuteUnique(self, nums):
        if not nums:
            return []
        nums.sort()
        ans = [[]]
        for i in nums:
            path = []
            l = len(ans[-1])
            for j in ans:
                for k in range(l, -1, -1):
                    if k < l and j[k] == i:
                        break
                    path.append(j[:k]+[i]+j[k:])
            ans = path
        return ans


s = Solution()
print(s.permuteUnique([1, 1, 3]))
