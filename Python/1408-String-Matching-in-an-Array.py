class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        n = len(words)
        words.sort(key=len)

        def _kmp(s, m):
            x = len(s)
            pfx = [0]*x

            for i in range(1, x):
                j = pfx[i-1]
                while j > 0 and s[i] != s[j]:
                    j = pfx[j-1]
                if s[i] == s[j]:
                    j += 1
                pfx[i] = j

            return pfx.count(m) > 0

        ans = []
        for i in range(n-1):
            m = len(words[i])
            s = '#'.join(words[i:])

            if _kmp(s, m):
                ans.append(words[i])

        return ans