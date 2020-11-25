class Solution:
    def letterCombinations(self, digits):
        # Solution 1
        d = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
             '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        ans = [''] if digits else []
        for num in digits:
            ans = [i+j for i in ans for j in d[num]]
        return ans

        # Solution 2(Faster)
        d = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
             '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        ans = ['']
        for num in digits:
            temp = d[num]
            newAns = []
            for letter in temp:
                for a in ans:
                    newAns.append(a+letter)
            ans = newAns
        return ans if digits else []


s = Solution()
print(s.letterCombinations("23"))
