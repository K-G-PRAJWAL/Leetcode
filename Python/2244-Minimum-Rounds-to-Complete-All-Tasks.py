class Solution:
    def minimumRounds(self, tasks):
        map = {}
        for task in tasks:
            if task not in map:
                map[task] = 1
            else:
                map[task] += 1
        min = 0
        for task in map:
            if map[task] == 1:
                return -1
            elif map[task] % 3 == 0:
                min += map[task]//3
            else:
                min += (map[task]//3) + 1
        return min


s = Solution()
print(s.minimumRounds([2, 2, 3, 3, 2, 4, 4, 4, 4, 4]))
