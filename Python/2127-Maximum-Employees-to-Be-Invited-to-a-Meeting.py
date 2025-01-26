class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)

        longest_cycle = 0
        visited = [False]*n
        length_2_cycles = []

        for i in range(n):
            if visited[i]:
                continue

            start, curr = i, i
            curr_set = set()

            while not visited[curr]:
                visited[curr] = True
                curr_set.add(curr)
                curr = favorite[curr]

            if curr in curr_set:
                length = len(curr_set)
                while start != curr:
                    length -= 1
                    start = favorite[start]
                longest_cycle = max(longest_cycle, length)
                if length == 2:
                    length_2_cycles.append([curr, favorite[curr]])

        inverted = defaultdict(list)
        for dst, src in enumerate(favorite):
            inverted[src].append(dst)

        def bfs(src, parent):
            q = deque([(src, 0)])
            max_length = 0

            while q:
                node, length = q.popleft()
                if node == parent:
                    continue
                max_length = max(max_length, length)
                for nei in inverted[node]:
                    q.append((nei, length + 1))

            return max_length

        chain_sum = 0
        for n1, n2 in length_2_cycles:
            chain_sum += bfs(n1, n2) + bfs(n2, n1) + 2

        return max(chain_sum, longest_cycle)