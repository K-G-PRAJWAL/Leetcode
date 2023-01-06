class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        buy = 0
        costs.sort()
        for i in range(len(costs)):
            if costs[i] <= coins:
                buy += 1
                coins -= costs[i]
            else:
                break
        return buy

    # Better Solution using Counting Sort
    def maxIceCream2(costs, coins):
        buy = 0
        maxCost = 0
        for cost in costs:
            maxCost = max(maxCost, cost)

        freq = [0 for i in range(maxCost+1)]
        for cost in costs:
            freq[cost] += 1

        for cost in range(maxCost+1):
            if freq[cost] == 0:
                continue
            if coins < cost:
                break
            count = min(freq[cost], coins//cost)
            coins -= cost * count
            buy += count
        return buy


s = Solution()
print(s.maxIceCream([1, 3, 2, 4, 1], 7))
