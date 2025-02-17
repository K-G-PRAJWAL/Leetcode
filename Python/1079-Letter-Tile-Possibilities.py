class Solution:
    def generate(self, tiles, curr, used, perms):
        perms.add(curr)

        for idx, ch in enumerate(tiles):
            if not used[idx]:
                used[idx] = True
                self.generate(tiles, curr+ch, used, perms)
                used[idx] = False

    def numTilePossibilities(self, tiles: str) -> int:
        n = len(tiles)
        perms = set()
        used = [False] * n

        self.generate(tiles, "", used, perms)
        return len(perms) - 1


class Solution:
    def generate(self, chars):
        ans = 0

        for idx in range(26):
            if chars[idx] == 0:
                continue

            ans += 1
            chars[idx] -= 1
            ans += self.generate(chars)
            chars[idx] += 1

        return ans

    def numTilePossibilities(self, tiles: str) -> int:
        chars = [0]*26
        for ch in tiles:
            chars[ord(ch)-ord('A')] += 1

        return self.generate(chars)
