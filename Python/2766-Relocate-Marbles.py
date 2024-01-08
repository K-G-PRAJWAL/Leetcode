class Solution:
    def relocateMarbles(self, nums: List[int], moveFrom: List[int], moveTo: List[int]) -> List[int]:
        s = set(nums)
        for i in range(len(moveFrom)):
            s.remove(moveFrom[i])
            s.add(moveTo[i])

        return sorted(s)

        # map = defaultdict(int)

        # for i in range(len(nums)):
        #     map[nums[i]] += 1

        # for i in range(len(moveFrom)):
        #     prevMarbles = map[moveFrom[i]]
        #     del map[moveFrom[i]]
        #     map[moveTo[i]] += prevMarbles

        # ans = sorted(map.keys())

        # return ans
