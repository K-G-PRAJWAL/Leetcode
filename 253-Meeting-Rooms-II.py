import heapq


class Solution:
    def minMeetingRooms(self, intervals):
        intervals.sort()
        rooms = 0
        meetings = []
        for interval in intervals:
            if not meetings:
                meetings.append((interval[1]))
                rooms += 1
            else:
                if interval[0] >= meetings[0]:
                    heapq.heappushpop(meetings, interval[1])
                else:
                    heapq.heappush(meetings, interval[1])
                    rooms += 1
        return rooms


s = Solution()
print(s.minMeetingRooms([[2, 15], [36, 45], [9, 29], [16, 23], [4, 9]]))
