class Solution:
    def combinationSum(self, candidates, target):
        # Solution 1 - DFS, Backtracking
        ans = []
        candidates.sort()
        self.helper(candidates, target, 0, [], ans)
        return ans

    def helper(self, arr, target, i, path, ans):
        if target == 0:
            ans.append(path)
            return
        for i in range(i, len(arr)):
            if arr[i] > target:
                break
            self.helper(arr, target-arr[i], i, path+[arr[i]], ans)

      # Solution 2 - DFS, Backtracking, Stack - Time: 93.33% | Space: 96.04%
        ans = []
        candidates.sort()
        self.helper(candidates, target, [], ans)
        return ans

    def helper(self, candidates, target, stk, ans):
        if target == 0:
            ans.append(stk)
            return

        for val in candidates:
            if val > target:
                break
            if stk and val < stk[-1]:
                continue
            self.helper(candidates, target - val, stk+[val], ans)


s = Solution()
print(s.combinationSum([2, 3, 6, 7], 7))
