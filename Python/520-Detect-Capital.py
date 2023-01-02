class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        count_uppers = 0
        count_lowers = 0
        n = len(word)
        for i in range(n):
            if word[i].isupper():
                count_uppers += 1
            else:
                count_lowers += 1
        if count_uppers == n or count_lowers == n:
            return True
        elif count_uppers == 1 and word[0].isupper():
            return True
        else:
            return False


s = Solution()
print(s.detectCapitalUse("India"))
