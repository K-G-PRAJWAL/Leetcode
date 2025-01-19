class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        rows, cols = len(heightMap), len(heightMap[0])

        min_heap = []

        # Visit border cells and add them to a MIN Heap
        for r in range(rows):
            for c in range(cols):
                if r in [0, rows-1] or c in [0, cols-1]:
                    heappush(min_heap, (heightMap[r][c], r, c))
                    heightMap[r][c] = -1 # Mark visited

        ans = 0
        max_height = -1

        # Multi-source BFS using shortest height to max height
        while min_heap:
            h, r, c = heappop(min_heap)
            max_height = max(max_height, h)

            ans += max_height - h

            neighbors = [[r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]]
            for nr, nc in neighbors:
                if (
                    nr < 0 or nc < 0 or
                    nr == rows or nc == cols or
                    heightMap[nr][nc] == -1
                ):
                    continue
                heappush(min_heap, (heightMap[nr][nc], nr, nc))
                heightMap[nr][nc] = -1

        return ans