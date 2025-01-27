class Solution:
    def checkIfPrerequisite_1(self, numCourses: int, prereq: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adj_list = {_: [] for _ in range(numCourses)}

        for edge in prereq:
            adj_list[edge[0]].append(edge[1])

        ans = []

        def dfs(adj_list, visited, src, dest):
            visited[src] = True
            if src==dest:
                return True
            for neighbor in adj_list.get(src):
                if not visited[neighbor]:
                    if dfs(adj_list, visited, neighbor, dest):
                        return True
            return False

        for q in queries:
            visited = [False]*numCourses
            ans.append(dfs(adj_list, visited, q[0], q[1]))
        return ans

    def checkIfPrerequisite_FloydWarshall(self, numCourses: int, prereq: List[List[int]], queries: List[List[int]]) -> List[bool]:
        check = [[False]*numCourses for _ in range(numCourses)]

        for edge in prereq:
            check[edge[0]][edge[1]] = True

        for intermediate in range(numCourses):
            for src in range(numCourses):
                for dest in range(numCourses):
                    check[src][dest] = check[src][dest] or ( check[src][intermediate] and check[intermediate][dest] )

        ans = []
        for q in queries:
            ans.append(check[q[0]][q[1]])
        return ans