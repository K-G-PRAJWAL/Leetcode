from heapq import *


class MedianFinder:
    # Solution 1 - O(nlog(n))
    def __init__(self):
        self.stream = []
        self.size = 0

    def addNum(self, num: int) -> None:
        self.stream.append(num)
        self.size += 1

    def findMedian(self) -> float:
        self.stream.sort()
        if self.size % 2 == 1:
            return self.stream[self.size//2]
        else:
            return (self.stream[self.size//2]+self.stream[self.size//2-1])/2

    # Solution 2 - O(log n)

    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num: int) -> None:
        if len(self.small) == len(self.large):
            heappush(self.large, -heappushpop(self.small, -num))
        else:
            heappush(self.small, -heappushpop(self.large, num))
        print(self.small, self.large)

    def findMedian(self) -> float:
        if len(self.small) == len(self.large):
            return (self.large[0] - self.small[0]) / 2
        else:
            return self.large[0]


s = MedianFinder()
print(s.addNum(1))
print(s.addNum(2))
print(s.findMedian())
print(s.addNum(3))
print(s.findMedian())
