class Solution:
    def productExceptSelf(self, nums):
        # Solution 1
        # res = [1 for i in nums]
        # l, r = 1, 1
        # n = len(nums)
        # for i in range(n):
        #     res[i] *= l
        #     res[-1-i] *= r
        #     l *= nums[i]
        #     r *= nums[-1-i]
        # return res

        # # Solution 2
        # n = len(nums)
        # ans = [1]*n
        # for i in range(1, n):
        #     ans[i] = ans[i-1]*nums[i-1]
        # x = 1
        # for i in range(n-1, -1, -1):
        #     ans[i] *= x
        #     x *= nums[i]
        # return ans

        # # Solution 3
        # n = len(nums)
        # l = 0
        # h = n-1
        # res = [1]*n
        # lP = rP = 1
        # while l < n:
        #     res[l] *= lP
        #     res[h] *= rP
        #     rP *= nums[h]
        #     lP *= nums[l]
        #     l += 1
        #     h -= 1
        # return res

        # Solution 4
        ans = 1
        n = len(nums)
        res = []
        for i in range(n):
            res.append(ans)
            ans *= nums[i]
        ans = 1
        for i in range(n-1, -1, -1):
            res[i] *= ans
            ans *= nums[i]
            print(ans, res)
        return res

        # Solution 5(fastest)
        # from itertools import accumulate
        # from operator import mul

        # x = list(accumulate(([1]+nums), mul))[:-1]
        # y = list(accumulate(([1]+nums[::-1]), mul))[::-1][1:]
        # return list(map(lambda x, y: x*y, x, y))


s = Solution()
print(s.productExceptSelf([1, 2, 3, 4]))
