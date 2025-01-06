class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        n = len(boxes)
        ans = [0] * n

        for i in range(n):
            if boxes[i] == '1':
                for j in range(n):
                    ans[j] += abs(j-i)

        return ans

    def minOperations_2(self, boxes: str) -> List[int]:
        n = len(boxes)
        ans = [0] * n

        l_balls, r_balls = 0, 0
        l_moves , r_moves = 0, 0

        for i in range(n):
            ans[i] += l_moves
            l_balls += int(boxes[i])
            l_moves += l_balls

            j = n - i - 1
            ans[j] += r_moves
            r_balls += int(boxes[j])
            r_moves += r_balls

        return ans
