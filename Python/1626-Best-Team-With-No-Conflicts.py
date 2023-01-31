class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        pairs = [[scores[i], ages[i]] for i in range(len(scores))]
        pairs.sort()

        dp = [pairs[i][0] for i in range(len(pairs))]

        for i in range(len(pairs)):
            max_score, max_age = pairs[i]
            for j in range(i):
                score, age = pairs[j]
                if max_age >= age:
                    dp[i] = max(dp[i], max_score+dp[j])

        return max(dp)
