class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        totalGas = 0
        totalCost = 0
        tank = 0
        start = 0

        for i in range(n):
            totalGas += gas[i]
            totalCost += cost[i]
            tank += (gas[i] - cost[i])
            if tank < 0:
                start = i+1
                tank = 0

        if totalGas < totalCost:
            return -1
        else:
            return start
