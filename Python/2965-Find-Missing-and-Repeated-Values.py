class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        cnt = defaultdict(int)

        for i in range(n):
            for j in range(n):
                cnt[grid[i][j]] += 1

        double, missing = 0, 0

        for i in range(1, n**2+1):
            if cnt[i] == 0:
                missing = i
            if cnt[i] == 2:
                double = i

        return [double, missing]