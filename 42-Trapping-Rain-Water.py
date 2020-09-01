class Solution:
    def trap(self, height):
        # l = 0
        # r = len(height)-1
        # maxiL = 0
        # maxiR = 0
        # ans = 0
        # while l<=r:
        #     if height[l]<=height[r]:
        #         if height[l]>=maxiL:
        #             maxiL = height[l]
        #         else:
        #             ans+=(maxiL-height[l])
        #         l+=1
        #     else:
        #         if height[r]>=maxiR:
        #             maxiR=height[r]
        #         else:
        #             ans+=(maxiR-height[r])
        #         r-=1
        # return ans

        ans = 0
        l, r = 0, len(height)-1
        lMax, rMax = 0, 0
        while l < r:
            lMax = max(lMax, height[l])
            rMax = max(rMax, height[r])
            if lMax < rMax:
                ans += lMax-height[l]
                l += 1
            else:
                ans += rMax-height[r]
                r -= 1
        return ans


s = Solution()
print(s.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
