class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stk = [-1]

        arr.append(0)
        ans = 0
        M = 10**9+7

        for i2, n in enumerate(arr):
            while stk and n < arr[stk[-1]]:
                i = stk.pop()
                i1 = stk[-1]
                left = i - i1
                right = i2 - i
                ans += left*right*arr[i]
            stk.append(i2)

        return ans % M
