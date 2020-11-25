import heapq

class Solution:
    # Solution 1
    def kthSmallest(self, mat, k):
        ans = mat[0][:k]
        for i in mat[1:]:
            heap = [(j +i[0], 0) for j in ans]
            ans = []
            for _ in range(k):
                if not heap:
                    break
                s, idx = heap[0]
                ans.append(s)
                if idx==len(mat[0])-1:
                    heapq.heappop(heap)
                else:
                    heapq.heapreplace(heap, (s+i[idx+1]-i[idx], idx+1))
        return ans[-1]
        

    # Solution 2
    def kthSmallest(self, mat, k):
        arrSums = self.helper(mat, k)
        return arrSums[k-1]
        
        
    def helper(self, mat, k):
        if len(mat)==1:
            return mat[0]
        return sorted([s+n for s in self.helper(mat[1:], k) for n in mat[0]])[:k]


s = Solution()
print(s.kthSmallest([[1,3,11],[2,4,6]], 5))