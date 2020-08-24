class MinStack:

    def __init__(self):
        self.stck = []

    def push(self, x: int) -> None:
        if not self.stck:
            self.stck.append((x, x))
        else:
            self.stck.append((x, min(x, self.stck[-1][1])))

    def pop(self) -> None:
        self.stck.pop()

    def top(self) -> int:
        if self.stck:
            return self.stck[-1][0]
        else:
            return None

    def getMin(self) -> int:
        if self.stck:
            return self.stck[-1][1]
        return None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
