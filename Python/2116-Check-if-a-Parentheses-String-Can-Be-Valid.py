class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)

        if n%2==1:
            return False

        total, open, close = 0, 0, 0
        for i in range(n-1, -1, -1):
            if locked[i] == '0':
                total += 1
            elif s[i] == '(':
                open += 1
            elif s[i] == ')':
                close += 1

            if total - open + close < 0:
                return False

        total, open, close = 0, 0, 0
        for i in range(n):
            if locked[i] =='0':
                total += 1
            elif s[i] == '(':
                open += 1
            elif s[i] == ')':
                close += 1
            if total + open - close < 0:
                return False

        return True