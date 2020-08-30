class Solution:
    def containsPattern(self, arr, m, k):
        # Solution 1
        # n = len(arr)
        # for i in range(n):
        #     if arr[i:i+m*k]==arr[i:i+m]*k:
        #         return True
        # return False

        # Soluton 2
        # n = len(arr)
        # i = 0
        # while i<=n-1:
        #     sub = arr[i:i+m]
        #     if sub*k==arr[i:i+m*k]:
        #         return True
        #     i+=1
        # return False

        # Solution 3
        cnt = 0
        i = 0
        n = len(arr)
        while i+m < n:
            if arr[i] != arr[i+m]:
                cnt = 0
            if arr[i] == arr[i+m]:
                cnt += 1
            if cnt == (k-1)*m:
                return True
            i += 1
        return False


s = Solution()
print(s.containsPattern([1, 2, 1, 2, 1, 1, 1, 3], 2, 2))
