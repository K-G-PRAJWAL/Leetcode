class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        ans = 0
        # Diagonals are the only way we can obtain max distance, if it were NS, WE combo, then they negate each other. Just keep adding the distance as long as they are part of diagonal or at the expense of k flips and find out the max distance.
        for diagonal in [{'N', 'E'}, {'N', 'W'}, {'S', 'E'}, {'S', 'W'}]:
            flip, dist = k, 0
            for ch in s:
                if ch in diagonal or flip:
                    dist += 1
                    flip -= 1 if ch not in diagonal else 0
                else:
                    dist -= 1
                ans = max(ans, dist)
        return ans

    def maxDistance(self, s, k) -> int:
        freq = defaultdict(int)
        ans = 0
        dirs_sum = 0

        # non-opposite dirs just increment the distance. Opposite directions(their minimum) negate the dist by twice the effect. If we play the flip(k) card, we can reverse the effect of opp directions.
        for ch in s:
            freq[ch] += 1

            dirs_sum += 1

            opp_dirs = min(freq['N'], freq['S']) + min(freq['W'] , freq['E'])

            dist = dirs_sum - (2 * opp_dirs)

            dist += 2 * min(k, opp_dirs)

            ans = max(ans, dist)

        return ans