class Solution:
    def constructDistancedSequence(self, n: int) -> List[int]:
        ans = [0]*(2*n-1)
        used = set()

        def backtrack(i):
            if i == len(ans):
                return True

            for num in reversed(range(1, n+1)):
                if num in used:
                    continue
                if num > 1 and (i+num>=len(ans) or (ans[i+num])):
                    continue

                used.add(num)
                ans[i] = num
                if num > 1:
                    ans[i+num] = num

                j = i+1
                while j<len(ans) and ans[j]:
                    j+=1

                if backtrack(j):
                    return True

                used.remove(num)
                ans[i] = 0
                if num > 1:
                    ans[i+num] = 0

            return False

        backtrack(0)
        return ans