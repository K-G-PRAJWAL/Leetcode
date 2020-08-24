class Solution:
    def twoSum(self, numbers, target):
        d = {}
        for i in range(len(numbers)):
            diff = target - numbers[i]
            if numbers[i] in d:
                return [d[numbers[i]]+1, i+1]
            else:
                d[diff] = i


s = Solution()
print(s.twoSum([2, 7, 11, 15], 9))
