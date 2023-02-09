class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        word_map = collections.defaultdict(set)
        ans = 0

        for w in ideas:
            word_map[w[0]].add(w[1:])

        for ch1 in word_map:
            for ch2 in word_map:
                if ch1 == ch2:
                    continue
                duplicate = 0
                for w in word_map[ch1]:
                    if w in word_map[ch2]:
                        duplicate += 1

                unique1 = len(word_map[ch1]) - duplicate
                unique2 = len(word_map[ch2]) - duplicate

                ans += unique1*unique2

        return ans
