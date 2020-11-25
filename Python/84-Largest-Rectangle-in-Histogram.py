class Solution:
    def largestRectangleArea(self, heights):
        # Solution 1
        heights.append(0)
        stack = [-1]
        ans = 0
        n = len(heights)
        for i in range(n):
            while heights[i]<heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i-1-stack[-1]
                ans = max(ans, h*w)
            stack.append(i)
        heights.pop()
        return ans
        
        # Solution 2
        stack = list()
        area = 0
        index = 0
        while index<len(heights):
            if not stack or heights[stack[-1]]<=heights[index]:
                stack.append(index)
                index+=1
            else:
                curr = stack.pop()
                area = max(area, heights[curr]*((index-1-stack[-1]) if stack else index))
        while stack:
            curr = stack.pop()
            area = max(area, heights[curr]*((index-1-stack[-1]) if stack else index))
        return area
                

s = Solution()
print(s.largestRectangleArea([2,1,5,6,2,3]))