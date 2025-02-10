class Solution:
    def clearDigits(self, s: str) -> str:
        stack = []

        for i in range(0, len(s)):
            if 97 > ord(s[i]) < 122:
                stack.pop()
            else:
                stack.append(s[i])

        return "".join(stack)