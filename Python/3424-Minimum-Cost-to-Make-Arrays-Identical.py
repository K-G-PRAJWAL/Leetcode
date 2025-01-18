class Solution:
    def minCost(self, arr: List[int], brr: List[int], k: int) -> int:
        n = len(arr)

        cost_1 = 0
        for x, y in zip(arr, brr):
            cost_1 += abs(x - y)

        arr.sort()
        brr.sort()

        cost_2 = 0
        for x, y in zip(arr, brr):
            cost_2 += abs(x - y)

        return min(cost_1, cost_2 + k)