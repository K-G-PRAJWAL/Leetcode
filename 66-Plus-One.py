class Solution:
    def plusOne(self, digits):
        newArr = [str(i) for i in digits]
        num = "".join(newArr)
        num = int(num)
        num += 1
        ans = []
        while num > 0:
            digit = num % 10
            ans.append(digit)
            num = num // 10
        return ans[::-1]


s = Solution()
print(s.plusOne([1, 9, 9]))
