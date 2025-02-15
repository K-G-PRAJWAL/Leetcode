class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        events = []
        for x, y, l in squares:
            events.append((y, l))
            events.append((y + l, -l))

        events.sort()
        total_area = sum(l * l for _, _, l in squares)
        half_area = total_area / 2
        current_area = 0
        active_length = 0
        prev_y = 0

        for y, delta in events:
            current_area += active_length * (y - prev_y)
            if current_area >= half_area:
                return y - (current_area - half_area) / active_length
            active_length += delta
            prev_y = y
