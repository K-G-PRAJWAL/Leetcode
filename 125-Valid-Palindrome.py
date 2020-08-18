# Solution 1 - (Faster)
class Solution:
    def isPalindrome(self, s: str) -> bool:
        newStr = ''
        for i in s:
            if i.isalnum():
                newStr += i.lower()
        return newStr[::-1] == newStr


# Solution 2 - Two Pointer
class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s)-1
        while l < r:
            if not s[l].isalnum():
                l += 1
            elif not s[r].isalnum():
                r -= 1
            elif s[l].lower() != s[r].lower():
                return False
            else:
                l += 1
                r -= 1
        return True


s = Solution()
print(s.isPalindrome('A man, a plan, a canal: Panama'))
print(s.isPalindrome('race a car'))
