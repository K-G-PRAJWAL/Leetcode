class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        first_sum = sum(grid[0])
        second_sum = 0

        min_sum = float("inf")

        for i in range(len(grid[0])):
            first_sum -= grid[0][i]
            min_sum = min(min_sum, max(first_sum, second_sum))
            second_sum += grid[1][i]

        return min_sum