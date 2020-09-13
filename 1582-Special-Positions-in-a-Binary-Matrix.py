class Solution:
    def numSpecial(self, mat):
        # r = len(mat)
        # c = len(mat[0])
        # trans = [[mat[j][i] for j in range(r)] for i in range(c)]
        # cnt = 0
        # for i in range(r):
        #     for j in range(c):
        #         if mat[i][j]==1 and sum(mat[i])==1 and sum(trans[j])==1:
        #             cnt+=1
        # return cnt

        r = len(mat)
        c = len(mat[0])
        cnt = 0
        colSum = [0 for i in range(c)]
        rowSum = [0 for j in range(r)]
        for i in range(r):
            for j in range(c):
                if mat[i][j] == 1:
                    colSum[j] += 1
                    rowSum[i] += 1
        for i in range(r):
            for j in range(c):
                if mat[i][j] == 1 and rowSum[i] == 1 and colSum[j] == 1:
                    cnt += 1
        return cnt


s = Solution()
print(s.numSpecial([[1, 0, 0],
                    [0, 0, 1],
                    [1, 0, 0]]))
