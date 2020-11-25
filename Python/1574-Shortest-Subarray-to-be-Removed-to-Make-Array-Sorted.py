class Solution:
    def findLengthOfShortestSubarray(self, arr):
        n = len(arr)
        srt = 0
        end = n-1
        while srt < n-1 and arr[srt] <= arr[srt+1]:
            srt += 1
        if srt == n-1:
            return 0
        while end >= srt and arr[end] >= arr[end-1]:
            end -= 1
        rem = min(n-srt-1, end)
        for iL in range(srt+1):
            if arr[iL] <= arr[end]:
                rem = min(rem, end-iL-1)
            elif end < n-1:
                end += 1
            else:
                break
        return rem


s = Solution()
print(s.findLengthOfShortestSubarray([1, 2, 3, 10, 4, 2, 3, 5]))
