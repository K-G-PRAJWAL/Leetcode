class Solution:
    def minDeletionSize(self, words):
        cnt = 0
        n = len(words)
        if n == 1:
            return words[0]
        for i in range(len(words[0])):
            for j in range(n - 1):
                currLetter = words[j][i]
                nextLetter = words[j+1][i]
                if currLetter > nextLetter:
                    cnt += 1
                    break
        return cnt


s = Solution()
print(s.minDeletionSize(["a", "b"]))
