class Solution:
    def findValidPair(self, s: str) -> str:
        map =  Counter(s)
        n = len(s)

        for i in range(n-1):
            x, y = s[i], s[i+1]

            if x != y and map[x]==int(x) and map[y]==int(y):
                return x+y

        return ""
