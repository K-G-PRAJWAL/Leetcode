class NumberContainers:

    def __init__(self):
        self.iTon = {}
        self.nToi = defaultdict(SortedSet)

    def change(self, index: int, number: int) -> None:
        if index in self.iTon:
            prev = self.iTon[index]
            self.nToi[prev].remove(index)

            if not self.nToi[prev]:
                del self.nToi[prev]

        self.iTon[index] = number
        self.nToi[number].add(index)


    def find(self, number: int) -> int:
        if number in self.nToi and self.nToi[number]:
            return self.nToi[number][0]
        return -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)



############## Alternative solution using Priority Queue ##########################
class NumberContainers:

    def __init__(self):
        self.iTon = {}
        self.nToi = defaultdict(list)

    def change(self, index: int, number: int) -> None:
        self.iTon[index] = number
        heapq.heappush(self.nToi[number], index)

    def find(self, number: int) -> int:
        if not self.nToi[number]:
            return -1
        while self.nToi[number]:
            i = self.nToi[number][0]
            if self.iTon.get(i)==number:
                return i
            heapq.heappop(self.nToi[number])
        return -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)