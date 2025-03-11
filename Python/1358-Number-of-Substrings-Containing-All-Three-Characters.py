class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        l = 0
        ans = 0
        cnt = defaultdict(int)

        for r in range(len(s)):
            cnt[s[r]] += 1

            while len(cnt) == 3:
                ans += (len(s) - r)
                cnt[s[l]] -= 1

                if cnt[s[l]] == 0:
                    cnt.pop(s[l])

                l += 1
        return ans
