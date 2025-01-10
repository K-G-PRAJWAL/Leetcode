class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        d = defaultdict(int)
        ans = []

        for word in words2:
            counter_2 = Counter(word)
            for ch in counter_2:
                d[ch] = max(d[ch], counter_2[ch])

        for word in words1:
            counter_1 = Counter(word)
            for ch in d:
                if counter_1[ch] < d[ch]:
                    break
            else:
                ans.append(word)
        return ans