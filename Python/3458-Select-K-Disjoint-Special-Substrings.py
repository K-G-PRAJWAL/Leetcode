class Solution:
    def maxSubstringLength(self, s: str, k: int) -> bool:
        n = len(s)
        if k == 0:
            return True

        first = {}
        last = {}
        for i, c in enumerate(s):
            if c not in first:
                first[c] = i
            last[c] = i

        intervals = []
        for l in range(n):
            if l != first[s[l]]:
                continue
            cur_min = first[s[l]]
            cur_max = last[s[l]]
            for r in range(l, n):
                cur_min = min(cur_min, first[s[r]])
                cur_max = max(cur_max, last[s[r]])
                if cur_min == l and cur_max == r and not (l == 0 and r == n - 1):
                    intervals.append((l, r))

        intervals.sort(key=lambda x: x[1])
        count = 0
        end = -1
        for a, b in intervals:
            if a > end:
                count += 1
                end = b
 
        return count >= k