class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        pairs = []

        def calc(n):
            sum = 0
            while n > 0:
                sum += n%10
                n //= 10
            return sum

        for n in nums:
            total = calc(n)
            pairs.append((total, n))

        pairs.sort()

        max_pair = -1
        for i in range(1, len(pairs)):
            curr = pairs[i][0]
            prev = pairs[i-1][0]

            if curr == prev:
                curr = pairs[i][1] + pairs[i-1][1]
                max_pair = max(max_pair, curr)

        return max_pair

    def maximumSum(self, nums: List[int]) -> int:
        groups = [[] for _ in range(82)]

        def calc(n):
            sum = 0
            while n > 0:
                sum += n%10
                n //= 10
            return sum

        max_pair = -1

        for n in nums:
            total = calc(n)
            heapq.heappush(groups[total], n)

            if len(groups[total]) > 2:
                heapq.heappop(groups[total])

        for heap in groups:
            if len(heap) == 2:
                x = heapq.heappop(heap)
                y = heapq.heappop(heap)
                max_pair = max(max_pair, x + y)

        return max_pair

    def maximumSum(self, nums: List[int]) -> int:
        ans = -1
        digits = [0]*82

        for n in nums:
            sum = 0
            temp = n
            while temp:
                temp, curr = divmod(temp, 10)
                sum += curr

            if digits[sum] > 0:
                ans = max(ans, digits[sum]+n)

            digits[sum] = max(digits[sum], n)

        return ans