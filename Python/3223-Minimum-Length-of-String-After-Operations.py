class Solution:
    def minimumLength(self, s: str) -> int:
        freq = Counter(s)

        deleted = 0
        for i in freq.values():
            if i%2==1:
                deleted += i - 1
            else:
                deleted += i - 2

        return len(s) - deleted