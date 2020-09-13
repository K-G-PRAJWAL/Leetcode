class Solution:
    def unhappyFriends(self, n: int, preferences, pairs):
        # adj = {}
        # for i, j in pairs:
        #     adj[i] = j
        #     adj[j] = i
        # map = [[0]*n for _ in range(n)]
        # for i in range(len(preferences)):
        #     tmp = n
        #     for j in range(n-1):
        #         map[i][preferences[i][j]] = tmp
        #         tmp-=1
        # cnt = 0
        # for i in range(n):
        #     happy = 1
        #     for j in range(n):
        #         if i==j:
        #             continue
        #         if happy==0:
        #             break
        #         if map[i][j]>map[i][adj[i]] and map[j][i]>map[j][adj[j]]:
        #             happy = 0
        #             cnt+=1
        # return cnt

        d = {}
        for i, j in pairs:
            d[i] = preferences[i][:preferences[i].index(j)]
            d[j] = preferences[j][: preferences[j].index(i)]
            print(d, (i, j))

        cnt = 0
        for i in d:
            for j in d[i]:
                if i in d[j]:
                    print(d[j])
                    cnt += 1
                    break
        return cnt


s = Solution()
print(s.unhappyFriends(4, [[1, 2, 3], [3, 2, 0],
                           [3, 1, 0], [1, 2, 0]], [[0, 1], [2, 3]]))
