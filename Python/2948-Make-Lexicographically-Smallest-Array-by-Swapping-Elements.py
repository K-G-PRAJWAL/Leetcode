class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        nums_sorted = sorted(nums)

        group = 0
        n_to_group = {}
        n_to_group[nums_sorted[0]] = group

        group_to_list = {}
        group_to_list[group] = deque([nums_sorted[0]])

        for i in range(1, len(nums)):
            if abs(nums_sorted[i] - nums_sorted[i-1]) > limit:
                group += 1

            n_to_group[nums_sorted[i]] = group

            if group not in group_to_list:
                group_to_list[group] = deque()
            group_to_list[group].append(nums_sorted[i])

        for i in range(len(nums)):
            n = nums[i]
            group = n_to_group[n]
            nums[i] = group_to_list[group].popleft()

        return nums