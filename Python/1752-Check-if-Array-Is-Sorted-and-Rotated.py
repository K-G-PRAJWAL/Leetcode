class Solution:
    def check(self, nums: List[int]) -> bool:
        n = len(nums)

        for x in range(n):
            is_sorted = []

            for i in range(x, n):
                is_sorted.append(nums[i])
            for i in range(x):
                is_sorted.append(nums[i])

            is_ordered = True
            for i in range(n-1):
                if is_sorted[i] > is_sorted[i+1]:
                    is_ordered = False
                    break
            if is_ordered:
                return True
        return False

    def check_optimized(self, nums: List[int]) -> bool:
        n = len(nums)

        if n <= 1:
            return True

        invert = 0
        for i in range(1, n):
            if nums[i] < nums[i-1]:
                invert += 1

        if nums[0] < nums[n-1]:
            invert += 1

        return invert <= 1