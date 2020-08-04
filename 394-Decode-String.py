class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        a, d = '', ''
        for letter in s:
            if letter.isdigit():
                d += letter
            elif letter.isalpha():
                a += letter
            elif letter == '[':
                stack.append((a, int(d)))
                a, d = '', ''
            elif letter == ']':
                prev, n = stack.pop()
                a = prev+a*n
        return a


s = Solution()
print(s.decodeString("3[a]2[bc]"))
