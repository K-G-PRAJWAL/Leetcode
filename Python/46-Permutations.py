class Solution:
    # Solution 1 - DFS+Backtracking
    def permute(self, nums):
        ans = []
        self.helper(nums, [], ans)
        return ans

    def helper(self, nums, path, ans):
        if not nums:
            ans.append(path)
        for i in range(len(nums)):
            print(i)
            print(nums)
            self.helper(nums[:i] + nums[i + 1:], path +
                        [nums[i]], ans)

    # Solution 2 - Iterative
    def permute(self, nums):
        if not nums:
            return [nums]
        ans = [[nums[0]]]
        for i in nums[1:]:
            temp = []
            for j in ans:
                for k in range(len(j)+1):
                    temp.append(j[:k]+[i]+j[k:])
            ans = temp
        return ans


s = Solution()
print(s.permute([1, 2, 3]))
