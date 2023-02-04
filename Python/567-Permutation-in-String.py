class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        freq = {}
        for ch in s1:
            freq[ch] = freq.get(ch, 0) + 1
        
        freq_copy = freq.copy()
        l = 0
        
        for i in range(len(s2)):
            if s2[i] in freq:
                freq[s2[i]] -= 1
                if freq[s2[i]] == 0 and i - l + 1 == len(s1):
                    return True
                while freq[s2[i]] < 0:
                    freq[s2[l]] += 1
                    l += 1            
            else:
                freq = freq_copy.copy()
                l = i + 1

        return False