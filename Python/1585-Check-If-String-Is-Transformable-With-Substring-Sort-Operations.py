import collections


class Solution:
    def isTransformable(self, s, t):
        # idx = [[] for _ in range(10)]
        # pos = [0 for _ in range(10)]
        # for i, ch in enumerate(s):
        #     idx[ord(ch)-48].append(i)
        # for ch in t:
        #     num = ord(ch)-48
        #     if pos[num]>=len(idx[num]):
        #         return False
        #     for i in range(num):
        #         if pos[i]<len(idx[i]) and idx[i][pos[i]] <idx[num][pos[num]]:
        #             return False
        #     pos[num]+=1
        # return True

        n = len(s)
        q = [collections.deque() for _ in range(10)]

        for i, ch in enumerate(s):
            q[int(ch)].append(i)

        for ch in t:
            num = int(ch)
            if len(q[num]) == 0:
                return False
            for j in range(num):
                if len(q[j]) > 0 and q[j][0] < q[num][0]:
                    return False
            q[num].popleft()
        return True


s = Solution()
print(s.isTransformable("34521", "23415"))
