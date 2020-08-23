class Solution:
    def minOperations(self, nums):
        cnt = 0
        w = 0
        for i in map(bin, nums):
            cnt += i.count("1")
            w = max(w, len(i) - 2)
        return cnt+w-1


s = Solution()
print(s.minOperations([1, 5]))
