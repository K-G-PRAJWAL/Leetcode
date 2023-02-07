class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        cnt = collections.defaultdict(int)

        l, total, ans = 0, 0, 0

        for r in range(len(fruits)):
            cnt[fruits[r]] += 1
            total += 1

            while len(cnt) > 2:
                f = fruits[l]
                cnt[f] -= 1
                total -= 1
                l += 1

                if not cnt[f]:
                    cnt.pop(f)

            ans = max(ans, total)

        return ans
