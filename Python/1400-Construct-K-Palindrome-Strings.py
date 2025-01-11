class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        n = len(s)
        if n < k:
            return False

        freq = [0]*26
        for ch in s:
            freq[ord(ch)-ord('a')] += 1

        odd_cnt = 0
        for i in range(26):
            if freq[i] % 2 == 1:
                odd_cnt += 1

        if odd_cnt > k:
            return False
        else:
            return True