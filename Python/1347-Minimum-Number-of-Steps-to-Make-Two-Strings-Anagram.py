class Solution:
    def minSteps(self, s: str, t: str) -> int:
        # print(Counter(s))
        # print(Counter(t))
        # print(Counter(s).values())
        # return sum((Counter(s) - Counter(t)).values())

        n_s = [0]*26
        n_t = [0]*26

        for ch in s:
            n_s[ord(ch) - ord('a')] += 1
        for ch in t:
            n_t[ord(ch) - ord('a')] += 1

        cnt = 0
        for i in range(26):
            cnt += abs(n_s[i] - n_t[i])

        return cnt // 2
