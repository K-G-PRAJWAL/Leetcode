class Solution:
    # Linear
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        n = len(intervals)
        ans = []
        i = 0
        while i < n and intervals[i][1] < newInterval[0]:
            ans.append(intervals[i])
            i += 1

        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])
            i += 1

        ans.append(newInterval)

        while i < n:
            ans.append(intervals[i])
            i += 1

        return ans

    # Binary
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        starts = []
        n = len(intervals)

        for i in range(n):
            starts.append(intervals[i][1])

        # Find right index to insert new interval
        idx = self.binary_search(starts, newInterval[0])

        ans = intervals[:idx]
        while idx < n and intervals[idx][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[idx][0])
            newInterval[1] = max(newInterval[1], intervals[idx][1])
            idx += 1

        ans.append(newInterval)
        ans += intervals[idx:]
        return ans

    def binary_search(self, starts, new_start):
        s, e = 0, len(starts) - 1
        while s <= e:
            mid = (s+e)//2
            if starts[mid] == new_start:
                return mid
            elif starts[mid] < new_start:
                s = mid + 1
            else:
                e = mid - 1
        return e+1
