class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n = len(s)

        diff = [0]*n

        for shift in shifts:
            if shift[2] == 1:
                diff[shift[0]] += 1

                if shift[1] + 1 < n:
                    diff[shift[1]+1] -= 1
            else:
                diff[shift[0]] -= 1

                if shift[1] + 1 < n:
                    diff[shift[1]+1] += 1

        ans = list(s)
        x = 0
        for i in range(n):
            x = (x + diff[i]) % 26

            if x < 0:
                x += 26

            ch = chr((ord(s[i]) - ord('a') + x)%26 + ord('a'))
            ans[i] = ch

        return "".join(ans)