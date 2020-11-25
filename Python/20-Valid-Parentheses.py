class Solution:
    def isValid(self, s):

        stack = []
        for i in range(len(s)):
            curr = s[i]
            if curr == '(' or curr == '[' or curr == '{':
                stack.append(curr)
            elif curr == ')' and len(stack) != 0 and stack[-1] == '(':
                stack.pop()
            elif curr == ']' and len(stack) != 0 and stack[-1] == '[':
                stack.pop()
            elif curr == '}' and len(stack) != 0 and stack[-1] == '{':
                stack.pop()
            else:
                return False
        return len(stack) == 0


s = Solution()
print(s.isValid('{[[]{}]}()()'))
