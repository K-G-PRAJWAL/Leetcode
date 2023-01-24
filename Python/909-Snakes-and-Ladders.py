class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        rows = len(board)
        board.reverse()

        def helper(node):
            r = (node - 1)//rows
            c = (node - 1) % rows
            if r % 2 == 1:
                c = rows - 1 - c
            return [r, c]

        q = deque()
        q.append([1, 0])  # [node, moves]
        visited = set()

        while q:
            node, moves = q.popleft()

            for i in range(1, 7):
                next_node = node+i
                row, col = helper(next_node)
                if board[row][col] != -1:
                    next_node = board[row][col]
                if next_node == rows**2:
                    return moves + 1
                if next_node not in visited:
                    visited.add(next_node)
                    q.append([next_node, moves+1])

        return -1
