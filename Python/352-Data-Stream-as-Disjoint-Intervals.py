from sortedcontainers import SortedDict


class SummaryRanges:

    def __init__(self):
        self.range = []
        self.set = set()

    def addNum(self, value: int) -> None:
        self.set.add(value)

    def getIntervals(self) -> List[List[int]]:
        nums = sorted(list(self.set))
        res = []
        i = 0
        while i < len(nums):
            s = nums[i]
            while i + 1 < len(nums) and nums[i] + 1 == nums[i+1]:
                i += 1
            res.append([s, nums[i]])
            i += 1

        return res


# Solution 2


class SummaryRanges:

    def __init__(self):
        self.tree_map = SortedDict()

    def addNum(self, value: int) -> None:
        self.tree_map[value] = True

    def getIntervals(self) -> List[List[int]]:
        ans = []

        for n in self.tree_map:
            if ans and ans[-1][1] + 1 == n:
                ans[-1][1] = n
            else:
                ans.append([n, n])

        return ans
