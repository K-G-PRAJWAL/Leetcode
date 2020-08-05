class Solution:
    def lengthOfLIS(self, nums):
        ans = []
        for i in nums:
            pos = self.b_s(ans, i)
            if pos == len(ans):
                ans.append(i)
            else:
                ans[pos] = i
        return len(ans)

    def b_s(self, arr, val):
        l, h = 0, len(arr)-1
        while l <= h:
            mid = (l+h)//2
            if arr[mid] < val:
                l = mid+1
            else:
                h = mid-1
        return l


s = Solution()
print(s.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))
