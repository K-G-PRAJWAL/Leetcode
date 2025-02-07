class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        color_map = defaultdict(int)
        ball_map = defaultdict(int)

        ans = []

        for ball, color in queries:
            if ball in ball_map:
                prev_color = ball_map[ball]
                color_map[prev_color] -= 1

                if color_map[prev_color] == 0:
                    del color_map[prev_color]

            ball_map[ball] = color

            color_map[color] = color_map.get(color, 0) + 1

            ans.append(len(color_map))

        return ans