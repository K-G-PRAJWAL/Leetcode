class Solution:
    def convertToTitle(self, n: int) -> str:
        # Solution 1
        alphabets = [chr(i) for i in range(ord('A'), ord('Z')+1)]
        ans = []
        while n > 0:
            ans.append(alphabets[(n-1) % 26])
            n = (n-1)//26
        ans.reverse()
        return "".join(ans)

        # Solution 2
        ans = ''
        while n > 0:
            n -= 1
            ans = chr(n % 26+65)+ans
            n //= 26
        return ans


s = Solution()
print(s.convertToTitle(32))
