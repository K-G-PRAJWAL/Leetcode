class Solution:
    def combinationSum2(self, candidates, target):
        candidates.sort()
        ans = []
        self.helper(candidates, 0, [], ans, target)
        return ans

    def helper(self, arr, idx, path, ans, target):
        if target == 0:
            ans.append(path)
            return
        for i in range(idx, len(arr)):
            if i > idx and arr[i] == arr[i-1]:
                continue
            if arr[i] > target:
                break
            self.helper(arr, i + 1, path + [arr[i]], ans, target - arr[i])


s = Solution()
print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
