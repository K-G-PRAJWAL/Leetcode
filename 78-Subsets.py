class Solution:
    def subsets(self, nums):

        # DFS Solution
        subsets = []
        self.dfs(sorted(nums), 0, [], subsets)
        return subsets

    def dfs(self, nums, idx, path, subsets):
        subsets.append(path)
        for i in range(idx, len(nums)):
            self.dfs(nums, i+1, path+[nums[i]], subsets)

        # Bit Manipulation Solution
        subsets = []
        nums.sort()
        for i in range(1 << len(nums)):
            sub = []
            for j in range(len(nums)):
                if i & 1 << j:
                    sub.append(nums[j])
            subsets.append(sub)
        return subsets

        # Iterative Solution
        subsets = [[]]
        for i in sorted(nums):
            subsets += [x + [i] for x in subsets]
        return subsets


s = Solution()
print(s.subsets([1, 2, 3]))
