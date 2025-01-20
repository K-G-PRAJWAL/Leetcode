class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        map = {}
        r_painted = [0]*m
        c_painted = [0]*n

        for r in range(m):
            for c in range(n):
                map[mat[r][c]] = [r, c]

        for i in range(len(arr)):
            r, c = map[arr[i]]

            r_painted[r] += 1
            c_painted[c] += 1

            if r_painted[r] == n or c_painted[c] == m:
                return i

        return -1

    def firstCompleteIndex_Optimized(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        map = {}

        for i in range(len(arr)):
            map[arr[i]] = i

        ans = float("inf")

        for r in range(m):
            max_idx = float("-inf")
            for c in range(n):
                i = map[mat[r][c]]
                max_idx = max(max_idx, i)
            ans = min(ans, max_idx)

        for c in range(n):
            max_idx = float("-inf")
            for r in range(m):
                i = map[mat[r][c]]
                max_idx = max(max_idx, i)
            ans = min(ans, max_idx)

        return ans