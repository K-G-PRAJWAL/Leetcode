class Solution(object):
    def minSwaps(self, arr):
        n = len(arr)
        ones = 0
        for i in range(n):
            if arr[i] == 1:
                ones += 1

        mem = {}
        if arr[0] == 1:
            mem[0] = 1
        for i in range(1, n):
            if arr[i] == 1:
                mem[i] = mem[i - 1] + 1
            else:
                mem[i] = mem[i - 1]

        maxOnes = float("-inf")
        tmp = ones
        for i in range(tmp - 1, n):
            if i == tmp - 1:
                ones = mem[i]
            else:
                ones = mem[i] - mem[i - tmp]
            if maxOnes < ones:
                maxOnes = ones

        zeroes = tmp - maxOnes
        return zeroes


s = Solution()
print(s.minSwaps([1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1]))
