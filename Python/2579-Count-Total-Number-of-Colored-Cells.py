class Solution:
    def coloredCells(self, n: int) -> int:
        ans = 1

        for i in range(n):
            ans += (i*4)

        return ans

        # return 4 * ((n*(n-1))//2) + 1