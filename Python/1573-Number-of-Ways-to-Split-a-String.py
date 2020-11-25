class Solution:
    def numWays(self, s):
        n = len(s)
        pos = []
        for i in range(n):
            if s[i] == '1':
                pos.append(i)
        cnt = len(pos)
        if cnt == 0:
            return ((n-1)*(n-2)//2) % (10**9+7)
        if cnt % 3 != 0:
            return 0
        oneSet = cnt//3
        return (pos[oneSet] - pos[oneSet-1])*(pos[oneSet*2] - pos[oneSet*2-1]) % (10**9+7)



s = Solution()
print(s.numWays("10101"))
print(s.numWays("0000"))
