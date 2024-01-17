class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        map = {}
        for i in arr:
            map[i] = map.get(i, 0) + 1

        return True if len(map) == len(set(map.values())) else False
