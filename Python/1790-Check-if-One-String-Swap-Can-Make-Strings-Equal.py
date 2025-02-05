class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        first = 0
        second = 0
        cnt = 0

        for i in range(len(s1)):
            if s1[i]!=s2[i]:
                cnt += 1

                if cnt > 2:
                    return False
                elif cnt == 1:
                    first = i
                else:
                    second = i

        return (
            s1[first] == s2[second]
            and s1[second] == s2[first]
        )