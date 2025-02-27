class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        n = len(arr)
        n_set = set(arr)
        max_len = 0

        for i in range(n):
            for j in range(i+1, n):
                prev = arr[j]
                curr = arr[i]+arr[j]
                curr_len = 2

                while curr in n_set:
                    prev, curr = curr, curr + prev
                    curr_len += 1
                    max_len = max(max_len, curr_len)

        return max_len

class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        n = len(arr)
        arr_map = {n: i for i, n in enumerate(arr)}
        max_len = 0

        dp = {}

        for i in reversed(range(n-1)):
            for j in reversed(range(i+1, n)):
                prev = arr[j]
                curr = arr[i]+arr[j]
                curr_len = 2

                if curr in arr_map:
                    curr_len = 1 + dp[(j, arr_map[curr])]
                    max_len = max(max_len, curr_len)

                dp[(i, j)] = curr_len

        return max_len